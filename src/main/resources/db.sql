create table resource (
   id                 INT8                 not null,
   name               VARCHAR(64)          null,
   para               VARCHAR(1024)         null,
   pid                INT8                 null,
   icon               VARCHAR(512)         null,
   path               VARCHAR(255)         null,
   rank               INT4                 not null,
   summary            VARCHAR(255)         null,
   module_code        VARCHAR(24)          not null,
   style              VARCHAR(64)          null,
   click              INT8                 null,
   rootid             INT8                 null,
   constraint pk_resource primary key (id)
);

CREATE TABLE "public"."role" (
  "id" int8 NOT NULL DEFAULT NULL,
  "name" varchar(64) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "summary" varchar(128) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  CONSTRAINT "pk_role_id" PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."role" 
  OWNER TO "hangye";
  
CREATE TABLE "public"."role_resource" (
  "role_id" INT8 not null,
  "resource_id" INT8 not null,
  CONSTRAINT "pk_role_resource" PRIMARY KEY ("role_id","resource_id")
)
;

ALTER TABLE "public"."role_resource" 
  OWNER TO "hangye";
  
  
  CREATE TABLE "public"."user_role" (
  "user_id" int8 NOT NULL DEFAULT NULL,
  "role_id" int8 NOT NULL DEFAULT NULL,
  CONSTRAINT "pk_user_role" PRIMARY KEY ("user_id", "role_id")
)
;

ALTER TABLE "public"."user_role" 
  OWNER TO "hangye";

COMMENT ON COLUMN "public"."user_role"."role_id" IS '角色ID';

COMMENT ON COLUMN "public"."user_role"."user_id" IS '用户ID';
 
 
 CREATE TABLE user (
  id INT8 NOT NULL,
  type int ,
  hash varchar(64) ,
  name varchar(32) ,
  pwd varchar(64) ,
  real_name varchar(64) ',
  avator varchar(512) ,
  gender varchar(10) ,
  email varchar(64) ,
  mobile varchar(32),
  title varchar(256) ,
  token varchar(64) ,
  create_time timestamp ,
  update_time timestamp ,
  is_send_message ,
  enabled int ,
  disabled_msg varchar(255) ,
  recommend_code varchar(10) ,
  primary key (id)
) ; 

CREATE TABLE meta (
  id int(11) NOT NULL ,
  catalog varchar(128) ,
  name varchar(128),
  value varchar(128) ,
  rank int,
  pid int,
  primary key (id)
);