--liquibase formatted sql

--changeset ardikapras:posreadonly-connect runInTransaction:false logicalFilePath:path-independent runOnChange:true

SELECT format('GRANT CONNECT ON DATABASE %I TO posreadonly;', datname)
FROM pg_database
where datname not in ('template1', 'template0', 'postgres');

-- this grants DML permissions on objects in public schema
GRANT USAGE ON SCHEMA public TO posreadonly;
GRANT SELECT ON ALL SEQUENCES IN SCHEMA public TO posreadonly;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO posreadonly;
ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA public
    GRANT SELECT ON TABLES TO posreadonly;
ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA public
    GRANT SELECT ON SEQUENCES TO posreadonly;

-- this grants DML permissions on objects in liquibase schema
ALTER DEFAULT PRIVILEGES FOR ROLE posuser IN SCHEMA public
    GRANT SELECT ON TABLES TO posreadonly;
ALTER DEFAULT PRIVILEGES FOR ROLE posuser IN SCHEMA public
    GRANT SELECT ON SEQUENCES TO posreadonly;

-- alter default privileges for posreadonly
ALTER DEFAULT PRIVILEGES IN SCHEMA public
    GRANT SELECT ON TABLES TO posreadonly;
ALTER DEFAULT PRIVILEGES IN SCHEMA public
    GRANT SELECT ON SEQUENCES TO posreadonly;

-- this grants DML permissions on objects owned by posuser in the liquibase schema
GRANT USAGE ON SCHEMA liquibase TO posreadonly;
GRANT SELECT ON ALL SEQUENCES IN SCHEMA liquibase TO posreadonly;
GRANT SELECT ON ALL TABLES IN SCHEMA liquibase TO posreadonly;
ALTER DEFAULT PRIVILEGES FOR ROLE posuser IN SCHEMA liquibase
    GRANT SELECT ON TABLES TO posreadonly;
ALTER DEFAULT PRIVILEGES FOR ROLE posuser IN SCHEMA liquibase
    GRANT SELECT ON SEQUENCES TO posreadonly;

-- this grants DML permissions on objects in liquibase schema
ALTER DEFAULT PRIVILEGES IN SCHEMA liquibase
    GRANT SELECT ON TABLES TO posreadonly;
ALTER DEFAULT PRIVILEGES IN SCHEMA liquibase
    GRANT SELECT ON SEQUENCES TO posreadonly;

-- this grants DML permissions on objects owned by pos_app_user in the liquibase schema
ALTER DEFAULT PRIVILEGES FOR ROLE pos_app_user IN SCHEMA liquibase GRANT SELECT ON TABLES TO posreadonly;
ALTER DEFAULT PRIVILEGES FOR ROLE pos_app_user IN SCHEMA liquibase GRANT SELECT, USAGE ON SEQUENCES TO posreadonly;
