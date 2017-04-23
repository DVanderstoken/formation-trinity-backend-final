CREATE TABLE T_DEPARTEMENT ( 
  REGION   varchar(2)  NOT NULL, 
  DEP      varchar(3)  NOT NULL,
  CHEFLIEU varchar(5)  DEFAULT NULL, 
  TNCC     varchar(1)  DEFAULT NULL, 
  NCC      varchar(70) DEFAULT NULL, 
  NCCENR   varchar(70) DEFAULT NULL, 
  CONSTRAINT pk_departement PRIMARY KEY (DEP)
)