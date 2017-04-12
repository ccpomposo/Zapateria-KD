--------------------------------------------------------
-- Archivo creado  - mi�rcoles-abril-12-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CABECERA
--------------------------------------------------------

  CREATE TABLE "VISUAL"."CABECERA" 
   (	"CABE_ID" NUMBER(*,0), 
	"CABE_TIPODEMOVIMIENTO" NUMBER(*,0), 
	"CABE_FORMADEPAGO" NUMBER(*,0), 
	"CABE_CLIENTE" NUMBER(*,0), 
	"CABE_DETALLE" NUMBER(*,0), 
	"CABE_TOTAL" NUMBER(18,2), 
	"CABE_FECHA" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CATEGORIA
--------------------------------------------------------

  CREATE TABLE "VISUAL"."CATEGORIA" 
   (	"CATE_ID" NUMBER(*,0), 
	"CATE_NOMBRE" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CLIENTE
--------------------------------------------------------

  CREATE TABLE "VISUAL"."CLIENTE" 
   (	"CLIE_ID" NUMBER(*,0), 
	"CLIE_PATERNO" VARCHAR2(30 BYTE), 
	"CLIE_MATERNO" VARCHAR2(30 BYTE), 
	"CLIE_NOMBRE" VARCHAR2(30 BYTE), 
	"CLIE_DIRECCION" VARCHAR2(80 BYTE), 
	"CLIE_TELEFONO" VARCHAR2(10 BYTE), 
	"CLIE_EMAIL" VARCHAR2(30 BYTE), 
	"CLIE_ACTIVO" NUMBER(*,0) DEFAULT 1
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table DETALLE
--------------------------------------------------------

  CREATE TABLE "VISUAL"."DETALLE" 
   (	"DETA_ID" NUMBER(*,0), 
	"DETA_ZAPATOMODELO" NUMBER(*,0), 
	"DETA_CANTIDAD" NUMBER(*,0), 
	"DETA_IMPORTE" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table FORMADEPAGO
--------------------------------------------------------

  CREATE TABLE "VISUAL"."FORMADEPAGO" 
   (	"FORM_ID" NUMBER(*,0), 
	"FORM_NOMBRE" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

--------------------------------------------------------
--  DDL for Table TALLAS
--------------------------------------------------------

  CREATE TABLE "VISUAL"."TALLAS" 
   (	"ZAPA_ID" NUMBER(*,0), 
	"TALLA" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TIPODEMOVIMIENTO
--------------------------------------------------------

  CREATE TABLE "VISUAL"."TIPODEMOVIMIENTO" 
   (	"TIPO_ID" NUMBER(*,0), 
	"TIPO_NOMBRE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table ZAPATO
--------------------------------------------------------

  CREATE TABLE "VISUAL"."ZAPATO" 
   (	"ZAPA_MODELO" NUMBER(*,0), 
	"ZAPA_COLOR" VARCHAR2(30 BYTE), 
	"ZAPA_TACON" NUMBER, 
	"ZAPA_PRECIO" NUMBER(10,2), 
	"CATE_ID" NUMBER(*,0), 
	"ZAPA_ACTIVO" NUMBER(*,0) DEFAULT 1
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Sequence SEQ_ID_CLIENTE
--------------------------------------------------------

   CREATE SEQUENCE  "VISUAL"."SEQ_ID_CLIENTE"  MINVALUE 1 MAXVALUE 1000000 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_ID_DETALLE
--------------------------------------------------------

   CREATE SEQUENCE  "VISUAL"."SEQ_ID_DETALLE"  MINVALUE 1 MAXVALUE 10000000 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_ID_ZAPATO
--------------------------------------------------------

   CREATE SEQUENCE  "VISUAL"."SEQ_ID_ZAPATO"  MINVALUE 1 MAXVALUE 1000000 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
REM INSERTING into VISUAL.CABECERA
SET DEFINE OFF;
Insert into VISUAL.CABECERA (CABE_ID,CABE_TIPODEMOVIMIENTO,CABE_FORMADEPAGO,CABE_CLIENTE,CABE_DETALLE,CABE_TOTAL,CABE_FECHA) values (1,1,1,2,4,5000,to_date('12/04/17','DD/MM/RR'));
REM INSERTING into VISUAL.CATEGORIA
SET DEFINE OFF;
Insert into VISUAL.CATEGORIA (CATE_ID,CATE_NOMBRE) values (1,'Dama');
Insert into VISUAL.CATEGORIA (CATE_ID,CATE_NOMBRE) values (2,'Caballero');
REM INSERTING into VISUAL.CLIENTE
SET DEFINE OFF;
Insert into VISUAL.CLIENTE (CLIE_ID,CLIE_PATERNO,CLIE_MATERNO,CLIE_NOMBRE,CLIE_DIRECCION,CLIE_TELEFONO,CLIE_EMAIL,CLIE_ACTIVO) values (1,'Cruz','Pomposo','Cesar Enrique','Miguel Dominguez 105','987654321','ccpomposo@gmail.com',1);
Insert into VISUAL.CLIENTE (CLIE_ID,CLIE_PATERNO,CLIE_MATERNO,CLIE_NOMBRE,CLIE_DIRECCION,CLIE_TELEFONO,CLIE_EMAIL,CLIE_ACTIVO) values (2,'Pichon','Avendano','Javier','Direccion','123456789','pichonjavier@outlook.com',1);
Insert into VISUAL.CLIENTE (CLIE_ID,CLIE_PATERNO,CLIE_MATERNO,CLIE_NOMBRE,CLIE_DIRECCION,CLIE_TELEFONO,CLIE_EMAIL,CLIE_ACTIVO) values (3,'Prueba','Baja','Cliente','Direccion','123456789','cliente@outlook.com',0);
REM INSERTING into VISUAL.DETALLE
SET DEFINE OFF;
Insert into VISUAL.DETALLE (DETA_ID,DETA_ZAPATOMODELO,DETA_CANTIDAD,DETA_IMPORTE) values (1,3,3,'3000');
Insert into VISUAL.DETALLE (DETA_ID,DETA_ZAPATOMODELO,DETA_CANTIDAD,DETA_IMPORTE) values (2,3,6,'1800');
Insert into VISUAL.DETALLE (DETA_ID,DETA_ZAPATOMODELO,DETA_CANTIDAD,DETA_IMPORTE) values (3,5,3,'5000');
Insert into VISUAL.DETALLE (DETA_ID,DETA_ZAPATOMODELO,DETA_CANTIDAD,DETA_IMPORTE) values (4,5,3,'5000');
REM INSERTING into VISUAL.FORMADEPAGO
SET DEFINE OFF;
Insert into VISUAL.FORMADEPAGO (FORM_ID,FORM_NOMBRE) values (1,'Contado');
Insert into VISUAL.FORMADEPAGO (FORM_ID,FORM_NOMBRE) values (2,'Credito');
REM INSERTING into VISUAL.PERSONA
SET DEFINE OFF;
Insert into VISUAL.PERSONA (PERS_ID,PERS_EDAD,PERS_PATERNO,PERS_MATERNO,PERS_NOMBRE) values (1,22,'Cruz','Pomposo','Cesar');
Insert into VISUAL.PERSONA (PERS_ID,PERS_EDAD,PERS_PATERNO,PERS_MATERNO,PERS_NOMBRE) values (2,88,'Cruz','Pomposo','Cesar');
REM INSERTING into VISUAL.TABLA
SET DEFINE OFF;
REM INSERTING into VISUAL.TALLAS
SET DEFINE OFF;
Insert into VISUAL.TALLAS (ZAPA_ID,TALLA) values (6,23);
Insert into VISUAL.TALLAS (ZAPA_ID,TALLA) values (6,24);
Insert into VISUAL.TALLAS (ZAPA_ID,TALLA) values (6,25);
Insert into VISUAL.TALLAS (ZAPA_ID,TALLA) values (6,26);
Insert into VISUAL.TALLAS (ZAPA_ID,TALLA) values (6,27);
REM INSERTING into VISUAL.TIPODEMOVIMIENTO
SET DEFINE OFF;
Insert into VISUAL.TIPODEMOVIMIENTO (TIPO_ID,TIPO_NOMBRE) values (1,'Venta');
REM INSERTING into VISUAL.ZAPATO
SET DEFINE OFF;
Insert into VISUAL.ZAPATO (ZAPA_MODELO,ZAPA_COLOR,ZAPA_TACON,ZAPA_PRECIO,CATE_ID,ZAPA_ACTIVO) values (3,'Negro',1,1000,2,1);
Insert into VISUAL.ZAPATO (ZAPA_MODELO,ZAPA_COLOR,ZAPA_TACON,ZAPA_PRECIO,CATE_ID,ZAPA_ACTIVO) values (4,'Azul',4,1350,1,0);
Insert into VISUAL.ZAPATO (ZAPA_MODELO,ZAPA_COLOR,ZAPA_TACON,ZAPA_PRECIO,CATE_ID,ZAPA_ACTIVO) values (5,'Plata',3,1200,1,1);
Insert into VISUAL.ZAPATO (ZAPA_MODELO,ZAPA_COLOR,ZAPA_TACON,ZAPA_PRECIO,CATE_ID,ZAPA_ACTIVO) values (6,'Cafe',0,600,2,1);
--------------------------------------------------------
--  DDL for Index PK$CABECERA$CABE_ID1
--------------------------------------------------------

  CREATE UNIQUE INDEX "VISUAL"."PK$CABECERA$CABE_ID1" ON "VISUAL"."CABECERA" ("CABE_ID", "CABE_DETALLE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK$DETALLE$DETA_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "VISUAL"."PK$DETALLE$DETA_ID" ON "VISUAL"."DETALLE" ("DETA_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK$FORMADEPAGO$FORM_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "VISUAL"."PK$FORMADEPAGO$FORM_ID" ON "VISUAL"."FORMADEPAGO" ("FORM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PERSONA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "VISUAL"."PERSONA_PK" ON "VISUAL"."PERSONA" ("PERS_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK$ZAPATO$ZAPA_MODELO
--------------------------------------------------------

  CREATE UNIQUE INDEX "VISUAL"."PK$ZAPATO$ZAPA_MODELO" ON "VISUAL"."ZAPATO" ("ZAPA_MODELO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK$CLIE$CLIE_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "VISUAL"."PK$CLIE$CLIE_ID" ON "VISUAL"."CLIENTE" ("CLIE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK$CATEGORIA$CATE_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "VISUAL"."PK$CATEGORIA$CATE_ID" ON "VISUAL"."CATEGORIA" ("CATE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK$TALLAS$ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "VISUAL"."PK$TALLAS$ID" ON "VISUAL"."TALLAS" ("ZAPA_ID", "TALLA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index TABLA_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "VISUAL"."TABLA_PK" ON "VISUAL"."TABLA" ("TBL_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK$TIPODEMOVIMIENTO$TIPO_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "VISUAL"."PK$TIPODEMOVIMIENTO$TIPO_ID" ON "VISUAL"."TIPODEMOVIMIENTO" ("TIPO_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table DETALLE
--------------------------------------------------------

  ALTER TABLE "VISUAL"."DETALLE" ADD CONSTRAINT "PK$DETALLE$DETA_ID" PRIMARY KEY ("DETA_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "VISUAL"."DETALLE" MODIFY ("DETA_IMPORTE" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."DETALLE" MODIFY ("DETA_CANTIDAD" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."DETALLE" MODIFY ("DETA_ZAPATOMODELO" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."DETALLE" MODIFY ("DETA_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CLIENTE
--------------------------------------------------------

  ALTER TABLE "VISUAL"."CLIENTE" MODIFY ("CLIE_ACTIVO" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."CLIENTE" ADD CONSTRAINT "PK$CLIE$CLIE_ID" PRIMARY KEY ("CLIE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "VISUAL"."CLIENTE" MODIFY ("CLIE_DIRECCION" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."CLIENTE" MODIFY ("CLIE_NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."CLIENTE" MODIFY ("CLIE_MATERNO" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."CLIENTE" MODIFY ("CLIE_PATERNO" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."CLIENTE" MODIFY ("CLIE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CABECERA
--------------------------------------------------------

  ALTER TABLE "VISUAL"."CABECERA" ADD CONSTRAINT "PK$CABECERA$CABE_ID1" PRIMARY KEY ("CABE_ID", "CABE_DETALLE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "VISUAL"."CABECERA" MODIFY ("CABE_FECHA" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."CABECERA" MODIFY ("CABE_TOTAL" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."CABECERA" MODIFY ("CABE_DETALLE" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."CABECERA" MODIFY ("CABE_CLIENTE" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."CABECERA" MODIFY ("CABE_FORMADEPAGO" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."CABECERA" MODIFY ("CABE_TIPODEMOVIMIENTO" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."CABECERA" MODIFY ("CABE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TIPODEMOVIMIENTO
--------------------------------------------------------

  ALTER TABLE "VISUAL"."TIPODEMOVIMIENTO" ADD CONSTRAINT "PK$TIPODEMOVIMIENTO$TIPO_ID" PRIMARY KEY ("TIPO_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "VISUAL"."TIPODEMOVIMIENTO" MODIFY ("TIPO_NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."TIPODEMOVIMIENTO" MODIFY ("TIPO_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CATEGORIA
--------------------------------------------------------

  ALTER TABLE "VISUAL"."CATEGORIA" ADD CONSTRAINT "PK$CATEGORIA$CATE_ID" PRIMARY KEY ("CATE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "VISUAL"."CATEGORIA" MODIFY ("CATE_NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."CATEGORIA" MODIFY ("CATE_ID" NOT NULL ENABLE);

--------------------------------------------------------
--  Constraints for Table ZAPATO
--------------------------------------------------------

  ALTER TABLE "VISUAL"."ZAPATO" MODIFY ("ZAPA_ACTIVO" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."ZAPATO" ADD CONSTRAINT "PK$ZAPATO$ZAPA_MODELO" PRIMARY KEY ("ZAPA_MODELO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "VISUAL"."ZAPATO" MODIFY ("CATE_ID" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."ZAPATO" MODIFY ("ZAPA_PRECIO" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."ZAPATO" MODIFY ("ZAPA_TACON" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."ZAPATO" MODIFY ("ZAPA_COLOR" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."ZAPATO" MODIFY ("ZAPA_MODELO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TALLAS
--------------------------------------------------------

  ALTER TABLE "VISUAL"."TALLAS" ADD CONSTRAINT "PK$TALLAS$ID" PRIMARY KEY ("ZAPA_ID", "TALLA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "VISUAL"."TALLAS" MODIFY ("TALLA" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."TALLAS" MODIFY ("ZAPA_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table FORMADEPAGO
--------------------------------------------------------

  ALTER TABLE "VISUAL"."FORMADEPAGO" ADD CONSTRAINT "PK$FORMADEPAGO$FORM_ID" PRIMARY KEY ("FORM_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "VISUAL"."FORMADEPAGO" MODIFY ("FORM_NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "VISUAL"."FORMADEPAGO" MODIFY ("FORM_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table CABECERA
--------------------------------------------------------

  ALTER TABLE "VISUAL"."CABECERA" ADD CONSTRAINT "FK$CABECERA$CABE_CLIENTE" FOREIGN KEY ("CABE_CLIENTE")
	  REFERENCES "VISUAL"."CLIENTE" ("CLIE_ID") ENABLE;
  ALTER TABLE "VISUAL"."CABECERA" ADD CONSTRAINT "FK$CABECERA$CABE_DETALLE" FOREIGN KEY ("CABE_DETALLE")
	  REFERENCES "VISUAL"."DETALLE" ("DETA_ID") ENABLE;
  ALTER TABLE "VISUAL"."CABECERA" ADD CONSTRAINT "FK$CABECERA$CABE_FORMADEPAGO" FOREIGN KEY ("CABE_FORMADEPAGO")
	  REFERENCES "VISUAL"."FORMADEPAGO" ("FORM_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DETALLE
--------------------------------------------------------

  ALTER TABLE "VISUAL"."DETALLE" ADD CONSTRAINT "FK$DETALLE$DETA_ZAPATOMODELO" FOREIGN KEY ("DETA_ZAPATOMODELO")
	  REFERENCES "VISUAL"."ZAPATO" ("ZAPA_MODELO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TALLAS
--------------------------------------------------------

  ALTER TABLE "VISUAL"."TALLAS" ADD CONSTRAINT "FK$TALLAS$ZAPA_ID" FOREIGN KEY ("ZAPA_ID")
	  REFERENCES "VISUAL"."ZAPATO" ("ZAPA_MODELO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ZAPATO
--------------------------------------------------------

  ALTER TABLE "VISUAL"."ZAPATO" ADD CONSTRAINT "FK$ZAPATO$ZAPA_CATE_ID" FOREIGN KEY ("CATE_ID")
	  REFERENCES "VISUAL"."CATEGORIA" ("CATE_ID") ENABLE;