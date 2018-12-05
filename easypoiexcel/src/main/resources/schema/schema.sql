#建表
#表语句插入
# c_application
CREATE TABLE `c_application` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `app_id` varchar(64) DEFAULT NULL COMMENT '开发者ID，提供给各个应用的设别码',
  `app_secret` varchar(64) DEFAULT NULL COMMENT '开发者密码是校验开发者身份的密码，具有极高的安全性',
  `index_url` varchar(255) DEFAULT NULL COMMENT '首页访问地址',
  `name_` varchar(20) DEFAULT NULL COMMENT '应用名称',
  `logo_url` varchar(200) DEFAULT NULL COMMENT '应用logo',
  `desc_` varchar(200) DEFAULT NULL COMMENT '功能描述',
  `code_` varchar(100) DEFAULT NULL COMMENT '应用编码',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `app_type` smallint(6) DEFAULT NULL COMMENT '应用/服务类型： 1 应用   2服务   3既是应用也是服务',
  `type_` varchar(100) DEFAULT NULL COMMENT '应用/服务分类（共性应用、统一平台、共性服务、共性模块等等）',
  `provider_` varchar(8) DEFAULT NULL COMMENT '提供方   pt 平台   zk 中科 等等',
  `status_` bit(1) DEFAULT NULL COMMENT '是否启用',
  `random_str` varchar(36) DEFAULT NULL COMMENT '随机序列',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `org_id` varchar(64) DEFAULT NULL COMMENT '应用所属单位Id',
  `org_system_code` varchar(64) DEFAULT NULL COMMENT '单位所属体系编码',
  `org_name` varchar(164) DEFAULT NULL COMMENT '单位名称',
  `reduce_time` double NOT NULL DEFAULT '0' COMMENT '使用此应用，可以节省多少工期（人/天）',
  `reduce_cost` int(11) NOT NULL DEFAULT '0' COMMENT '使用此应用，可以节省多少前（元）',
  `original_time` double NOT NULL DEFAULT '0' COMMENT '此应用程序的初始预计工期（人/天）',
  `original_cost` int(11) NOT NULL DEFAULT '0' COMMENT '此应用程序的初始预计成本（人（元）',
  `is_fast_app` char(1) DEFAULT 'N' COMMENT '是否快速应用开发',
  `biz_config_id` bigint(20) DEFAULT NULL COMMENT '配置表关联ID',
  `hots_count` int(11) DEFAULT '0' COMMENT '热门程度',
  `reduce_build_cost` int(11) NOT NULL DEFAULT '0' COMMENT '使用此应用，可以节省多少建设成本（元）',
  `reduce_use_cost` int(11) NOT NULL DEFAULT '0' COMMENT '使用此应用，可以节省多少使用成本（元）',
  `reduce_protect_cost` int(11) NOT NULL DEFAULT '0' COMMENT '使用此应用，可以节省多少维护成本（元）',
  `public_is` bit(1) NOT NULL DEFAULT b'0' COMMENT '应用是否公有的   true表示公有，谁都可以访问，至于应用内部的资源，应用程序自己决定，要想有公有的菜单，完全可以在前端写死',
  `service_id` varchar(100) DEFAULT NULL COMMENT '服务注册中心的唯一标示： 比如eurake中的serviceId',
  `full_root_path` varchar(200) DEFAULT NULL COMMENT '应用程序的完整根路径',
  PRIMARY KEY (`id`),
  UNIQUE KEY `app_id_unique` (`app_id`) USING BTREE COMMENT 'appId必须唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用';

#f_file_usernum
CREATE TABLE `f_file_usernum` (
  `id` bigint(20) NOT NULL,
  `app_id` varchar(64) DEFAULT NULL COMMENT '应用id',
  `type` varchar(255) DEFAULT 'pan' COMMENT '文件类型 云盘数据:pan  接口数据:api',
  `data_type` varchar(255) DEFAULT NULL COMMENT '数据类型 image/video/audio/doc/other/DIR',
  `num` varchar(255) DEFAULT NULL COMMENT '数量',
  `fyear_month` varchar(50) DEFAULT NULL COMMENT '年月',
  `create_time` datetime DEFAULT NULL,
  `create_user` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件文件数量表';

#地区导入表
CREATE TABLE `b_area` (
  `id` bigint(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `code` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '地区编码',
  `full_name` varchar(255) DEFAULT NULL COMMENT '全名',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `parent_id` bigint(11) DEFAULT NULL COMMENT '父id',
  `tree_path` varchar(255) DEFAULT NULL COMMENT '路径',
  `longitude` varchar(255) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(255) DEFAULT NULL COMMENT '维度',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` bigint(11) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(11) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='地区表';