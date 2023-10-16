import org.jooq.meta.jaxb.MatcherRule
import org.jooq.meta.jaxb.MatcherTransformType
import org.jooq.meta.jaxb.Matchers
import org.jooq.meta.jaxb.MatchersTableType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.spring")
    id("org.jetbrains.kotlin.plugin.allopen")
    id("nu.studer.jooq") version "7.1.1"
}

group = "com.ardikapras"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    developmentOnly
}

repositories {
    mavenCentral()
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.Embeddable")
    annotation("jakarta.persistence.MappedSuperclass")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-logging")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1") // For asynchronous database access, if needed
    implementation("org.jooq:jooq:3.18.0")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2") // You have to define this implicitly because jOOQ relies on them since 3.17.*
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0") // You have to define this implicitly because jOOQ relies on them since 3.17.*
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    runtimeOnly("org.postgresql:postgresql")
    jooqGenerator("org.postgresql:postgresql:42.5.4")
    jooqGenerator("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")
}

// need all of these because of jooqGenerator
val dbUrl = System.getenv("DB_URL") ?: "jdbc:postgresql://localhost:5432/simplepos"
val dbUser = System.getenv("DB_USER") ?: "posuser"
val dbPassword = System.getenv("DB_PASSWORD") ?: "posuser"
val dbDriver = "org.postgresql.Driver"
val dbSchema = "public"
val jooqVersion = "3.17.4"

jooq {
    version.set(jooqVersion)

    configurations {
        create("main") {
            generateSchemaSourceOnCompilation.set(false)

            jooqConfiguration.apply {
                jdbc.apply {
                    driver = dbDriver
                    url = dbUrl
                    user = dbUser
                    password = dbPassword
                }
                generator.apply {
                    name = "org.jooq.codegen.KotlinGenerator"
                    database.apply {
                        excludes =
                            "databasechangelog|databasechangeloglock_prepare|databasechangelog_prepare|Public|DefaultCatalog"
                        inputSchema = dbSchema
                    }
                    generate.apply {
                        isDeprecated = false
                        isValidationAnnotations = true
                        isJpaAnnotations = true
                        isImmutablePojos = true
                    }
                    target.apply {
                        directory = "src/main/kotlin/jooq"
                        packageName = "com.ardikapras.simplepos.domain.model.schema"
                    }
                    strategy.apply {
                        name = "PojoSuffixStrategy"
                        matchers = Matchers().apply {
                            tables = listOf(
                                MatchersTableType().apply {
                                    pojoClass = MatcherRule().apply {
                                        transform = MatcherTransformType.PASCAL
                                        expression = "\$0_Pojo"
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}
//
//tasks.named('test') {
//	useJUnitPlatform()
//}
