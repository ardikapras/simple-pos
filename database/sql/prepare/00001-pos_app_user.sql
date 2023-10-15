--liquibase formatted sql

--changeset ardikapras:pos_app_user-connect runInTransaction:false logicalFilePath:path-independent runOnChange:true

SELECT format('GRANT CONNECT ON DATABASE %I TO pos_app_user;', datname)
FROM pg_database
where datname not in ('template1', 'template0', 'postgres');

-- this grants DML permissions on pre-existing objects in public schema (if any)
GRANT USAGE ON SCHEMA public TO pos_app_user;
GRANT SELECT ON ALL SEQUENCES IN SCHEMA public TO pos_app_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO pos_app_user;

-- this grants DML permissions on future postgres-owned objects in public schema
ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA public
    GRANT SELECT ON TABLES TO pos_app_user;
ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA public
    GRANT SELECT ON SEQUENCES TO pos_app_user;

-- this grants DML permissions on future posuser-owned objects in public schema
ALTER DEFAULT PRIVILEGES FOR ROLE posuser IN SCHEMA public
    GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO pos_app_user;
ALTER DEFAULT PRIVILEGES FOR ROLE posuser IN SCHEMA public
    GRANT SELECT ON SEQUENCES TO pos_app_user;

-- this grants DML permissions on pos_app_user-owned objects in public schema
ALTER DEFAULT PRIVILEGES IN SCHEMA public
    GRANT SELECT ON TABLES TO pos_app_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public
    GRANT SELECT ON SEQUENCES TO pos_app_user;

-- this grants DML permissions on objects in liquibase schema
GRANT USAGE ON SCHEMA liquibase TO pos_app_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA liquibase
    GRANT SELECT ON TABLES TO pos_app_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA liquibase
    GRANT SELECT ON SEQUENCES TO pos_app_user;

-- also allow creation (for now) by pos_app_user
GRANT CREATE ON SCHEMA liquibase TO pos_app_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA liquibase TO pos_app_user;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA liquibase TO pos_app_user;
ALTER DEFAULT PRIVILEGES FOR ROLE posuser IN SCHEMA liquibase GRANT INSERT, SELECT, UPDATE, DELETE ON TABLES TO pos_app_user;
ALTER DEFAULT PRIVILEGES FOR ROLE posuser IN SCHEMA liquibase GRANT SELECT, UPDATE, USAGE ON SEQUENCES TO pos_app_user;
