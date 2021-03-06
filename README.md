# etl-nemi
ETL NEMI to WQP's nwis-ws-start schema

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/4f3a8349e427482cb5c25ba89f7344a5)](https://www.codacy.com/app/usgs_wma_dev/etl-nemi?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=NWQMC/etl-nemi&amp;utm_campaign=Badge_Grade)

This repo contains a spring batch application which runs the NEMI to WQP NWIS schema
ETL. 

## Local Configuration
In order to run locally, you will need connection information to the NEMI database. For the WQP NWIS schema, you can use the docker commands in schema-nwis-ws-star to spin up a local postgres database.

You will need to create an application.yml file containing the following:
```yaml
NWIS_WS_STAR_HOST: <postgres_nwis_ws_star_host>
NWIS_WS_STAR_PORT: <postgres_nwis_ws_star_port>
NWIS_WS_STAR_DB: <nwis_ws_star_db>
NWIS_WS_STAR_USERNAME: <nwis_ws_star>
NWIS_WS_STAR_PASSWORD: <nwis_ws_sta>

NEMI_HOST: <oracle_nemi_host>
NEMI_PORT: <oracle_nemi_port>
NEMI_NWISRA_DB: <nemi_db_name>
NEMI_USERNAME: <nemi_username>
NEMI_PASSWORD: <nemi_password>
```

You can then run the ETL with the following:
```% mvn spring-boot:run```

The project is currently set up to run the job every time the command is launched.