CREATE TABLE IF NOT EXISTS user_table(
   id   BIGSERIAL PRIMARY KEY ,
   password  VARCHAR(254) NOT NULL ,
   username  VARCHAR(254) NOT NULL
);
CREATE TABLE IF NOT EXISTS transformersubstations
(
    id    BIGSERIAL PRIMARY KEY ,
    namesubs  VARCHAR(200) NOT NULL ,
    ip  VARCHAR(200) NOT NULL ,
    zone  VARCHAR(200) NOT NULL ,
    user_id BIGINT  REFERENCES user_table(id)
);