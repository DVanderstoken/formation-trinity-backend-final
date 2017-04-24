CREATE TABLE popcom
(
   code_region varchar(2), 
   nom_region varchar(100), 
   code_departement varchar(3), 
   code_arrondissement varchar(1), 
   code_canton varchar(2), 
   code_commune varchar(3), 
   nom_commune varchar(100), 
   pop_municipale varchar(10), 
   pop_a_part varchar(10), 
   pop_totale varchar(10),
   CONSTRAINT pk_pays PRIMARY KEY (code_region, code_departement, code_commune)
);
