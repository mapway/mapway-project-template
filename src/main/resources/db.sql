/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : PostgreSQL
 Source Server Version : 90605
 Source Host           : localhost:5432
 Source Catalog        : hangye
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90605
 File Encoding         : 65001

 Date: 10/09/2017 14:45:40
*/


-- ----------------------------
-- Sequence structure for se_test_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."se_test_id";
CREATE SEQUENCE "public"."se_test_id" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
COMMENT ON SEQUENCE "public"."se_test_id" IS '序列';

-- ----------------------------
-- Sequence structure for seq_app_data_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_app_data_id";
CREATE SEQUENCE "public"."seq_app_data_id" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_corporation_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_corporation_id";
CREATE SEQUENCE "public"."seq_corporation_id" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
COMMENT ON SEQUENCE "public"."seq_corporation_id" IS '公司表递增主键';

-- ----------------------------
-- Sequence structure for seq_meta_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_meta_id";
CREATE SEQUENCE "public"."seq_meta_id" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_resource_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_resource_id";
CREATE SEQUENCE "public"."seq_resource_id" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_role_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_role_id";
CREATE SEQUENCE "public"."seq_role_id" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_user_id
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."seq_user_id";
CREATE SEQUENCE "public"."seq_user_id" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for app_data
-- ----------------------------
DROP TABLE IF EXISTS "public"."app_data";
CREATE TABLE "public"."app_data" (
  "id" int8 NOT NULL DEFAULT nextval('seq_app_data_id'::regclass),
  "name" varchar(64) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL,
  "logo" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "service_tel" varchar(64) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "enteriprise" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "copyright" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "icp" varchar(64) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "appkey" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL
)
;
COMMENT ON COLUMN "public"."app_data"."id" IS '应用ID';
COMMENT ON COLUMN "public"."app_data"."name" IS '名称';
COMMENT ON COLUMN "public"."app_data"."logo" IS 'logo';
COMMENT ON COLUMN "public"."app_data"."service_tel" IS '服务电话';
COMMENT ON COLUMN "public"."app_data"."enteriprise" IS '企业名称';
COMMENT ON COLUMN "public"."app_data"."copyright" IS '版权信息';
COMMENT ON COLUMN "public"."app_data"."icp" IS 'icp备案';
COMMENT ON COLUMN "public"."app_data"."appkey" IS '关键字信息';
COMMENT ON TABLE "public"."app_data" IS '应用信息';

-- ----------------------------
-- Records of app_data
-- ----------------------------
INSERT INTO "public"."app_data" VALUES (1, '能源解决方案', '123', '400-000-0000', '泛能网络科技', '&copy;2018', '京ICP000000', '');

-- ----------------------------
-- Table structure for meta
-- ----------------------------
DROP TABLE IF EXISTS "public"."meta";
CREATE TABLE "public"."meta" (
  "id" int4 NOT NULL DEFAULT nextval('seq_meta_id'::regclass),
  "catalog" varchar(128) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "name" varchar(128) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "code" varchar(128) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "rank" int4 DEFAULT 0,
  "pid" int4 DEFAULT 0
)
;
COMMENT ON COLUMN "public"."meta"."id" IS '元数据ID';
COMMENT ON COLUMN "public"."meta"."catalog" IS '分类目录';
COMMENT ON COLUMN "public"."meta"."name" IS '名称';
COMMENT ON COLUMN "public"."meta"."code" IS 'code';
COMMENT ON COLUMN "public"."meta"."rank" IS '排序';
COMMENT ON COLUMN "public"."meta"."pid" IS '父ID';
COMMENT ON TABLE "public"."meta" IS '元数据信息';

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS "public"."resource";
CREATE TABLE "public"."resource" (
  "id" int8 NOT NULL DEFAULT nextval('seq_resource_id'::regclass),
  "name" varchar(64) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "para" varchar(1024) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "pid" int8 NOT NULL DEFAULT 0,
  "icon" varchar(512) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "path" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "rank" int4 NOT NULL DEFAULT 0,
  "summary" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "code" varchar(24) COLLATE "pg_catalog"."default" NOT NULL DEFAULT NULL,
  "style" varchar(64) COLLATE "pg_catalog"."default" DEFAULT ''::character varying,
  "click" int8 DEFAULT 0,
  "rootid" int8 NOT NULL DEFAULT 0
)
;
COMMENT ON COLUMN "public"."resource"."id" IS '资源ID';
COMMENT ON COLUMN "public"."resource"."name" IS '资源名称';
COMMENT ON COLUMN "public"."resource"."para" IS '模块参数';
COMMENT ON COLUMN "public"."resource"."pid" IS '父ID';
COMMENT ON COLUMN "public"."resource"."icon" IS '图标相对路径';
COMMENT ON COLUMN "public"."resource"."path" IS '路径信息';
COMMENT ON COLUMN "public"."resource"."rank" IS '排序';
COMMENT ON COLUMN "public"."resource"."summary" IS '资源说明';
COMMENT ON COLUMN "public"."resource"."code" IS '模块代码';
COMMENT ON COLUMN "public"."resource"."style" IS 'CSS样式';
COMMENT ON COLUMN "public"."resource"."click" IS '点击次数';
COMMENT ON COLUMN "public"."resource"."rootid" IS '根ID';
COMMENT ON TABLE "public"."resource" IS '系统资源表';

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS "public"."role";
CREATE TABLE "public"."role" (
  "id" int8 NOT NULL DEFAULT nextval('seq_role_id'::regclass),
  "name" varchar(64) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "summary" varchar(128) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying
)
;
COMMENT ON COLUMN "public"."role"."id" IS '角色ID';
COMMENT ON COLUMN "public"."role"."name" IS '角色名称';
COMMENT ON COLUMN "public"."role"."summary" IS '角色说明';
COMMENT ON TABLE "public"."role" IS '角色表';

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS "public"."role_resource";
CREATE TABLE "public"."role_resource" (
  "role_id" int8 NOT NULL DEFAULT NULL,
  "res_id" int8 NOT NULL DEFAULT NULL
)
;
COMMENT ON COLUMN "public"."role_resource"."role_id" IS '角色ID';
COMMENT ON COLUMN "public"."role_resource"."res_id" IS '资源ID';
COMMENT ON TABLE "public"."role_resource" IS '角色资源ID';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS "public"."user";
CREATE TABLE "public"."user" (
  "id" int8 NOT NULL DEFAULT nextval('seq_user_id'::regclass),
  "account_type" varchar(32) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "hash" varchar(64) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "name" varchar(32) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "pwd" varchar(64) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "real_name" varchar(64) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "avator" varchar(512) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "gender" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "email" varchar(64) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "mobile" varchar(32) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "title" varchar(256) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "token" varchar(64) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "create_time" timestamp(6) DEFAULT NULL::timestamp without time zone,
  "update_time" timestamp(6) DEFAULT NULL::timestamp without time zone,
  "is_send_message" int4 DEFAULT NULL,
  "enabled" int4 DEFAULT NULL,
  "disabled_msg" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "recommend_code" varchar(10) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "last_time" timestamp(6) DEFAULT NULL,
  "user_type" varchar(16) COLLATE "pg_catalog"."default" DEFAULT NULL,
  "user_identities" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL
)
;
COMMENT ON COLUMN "public"."user"."id" IS '用户ID';
COMMENT ON COLUMN "public"."user"."last_time" IS '最后登录时间';
COMMENT ON COLUMN "public"."user"."user_type" IS '用户类型';
COMMENT ON COLUMN "public"."user"."user_identities" IS '用户标识';
COMMENT ON TABLE "public"."user" IS '用户表';

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_role";
CREATE TABLE "public"."user_role" (
  "user_id" int8 NOT NULL DEFAULT NULL,
  "role_id" int8 NOT NULL DEFAULT NULL
)
;
COMMENT ON COLUMN "public"."user_role"."user_id" IS '用户ID';
COMMENT ON COLUMN "public"."user_role"."role_id" IS '角色ID';
COMMENT ON TABLE "public"."user_role" IS '用户角色表';

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."se_test_id"', 2, true);
SELECT setval('"public"."seq_app_data_id"', 2, false);
SELECT setval('"public"."seq_corporation_id"', 6, true);
SELECT setval('"public"."seq_meta_id"', 2, false);
SELECT setval('"public"."seq_resource_id"', 2, false);
SELECT setval('"public"."seq_role_id"', 2, false);
SELECT setval('"public"."seq_user_id"', 2, false);

-- ----------------------------
-- Primary Key structure for table app_data
-- ----------------------------
ALTER TABLE "public"."app_data" ADD CONSTRAINT "app_data_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table meta
-- ----------------------------
ALTER TABLE "public"."meta" ADD CONSTRAINT "meta_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table resource
-- ----------------------------
ALTER TABLE "public"."resource" ADD CONSTRAINT "pk_resource" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table role
-- ----------------------------
ALTER TABLE "public"."role" ADD CONSTRAINT "pk_role_id" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table role_resource
-- ----------------------------
ALTER TABLE "public"."role_resource" ADD CONSTRAINT "pk_role_resource" PRIMARY KEY ("role_id", "res_id");

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE "public"."user" ADD CONSTRAINT "user_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table user_role
-- ----------------------------
ALTER TABLE "public"."user_role" ADD CONSTRAINT "pk_user_role" PRIMARY KEY ("user_id", "role_id");
