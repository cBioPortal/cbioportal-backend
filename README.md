#### ℹ️ Note: This is an attempt at repackaging the cBioPortal backend into a more modern java app but is not used yet in production

# cbioportal-backend

## Services needed

All services are configured in the `src/main/resources/application.properties` file.

#### MySQL Service

Host: localhost

Port: 3306

DB: testDB

SETUP SQL

```
CREATE TABLE testModel (
   id int,
   name varchar200
);
INSERT INTO testModel (id, name)
VALUES (1, 'jane');
```


#### ClickHouseDB Service (Optional)

Host: localhost

Port: 8123

DB: cbioportal

Username: cbio

Password: P@ssword1

Note: This was developed using the cBioPortal ClickHouse initiative
