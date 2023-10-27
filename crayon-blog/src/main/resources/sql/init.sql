-- 创建数据库,指定字符集UTF-8
CREATE
DATABASE crayon
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

-- 创建用户表
DROP TABLE IF EXISTS Cr_User;
CREATE TABLE Cr_User
(
    user_id           INT AUTO_INCREMENT PRIMARY KEY COMMENT '用户id',
    username          VARCHAR(255) NOT NULL COMMENT '用户名',
    email             VARCHAR(255) NOT NULL COMMENT '用户邮箱',
    password          VARCHAR(255) NOT NULL COMMENT '用户密码',
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '用户表';

-- 创建分类表
DROP TABLE IF EXISTS Cr_Categorie;
CREATE TABLE Cr_Categorie
(
    category_id   INT AUTO_INCREMENT PRIMARY KEY  COMMENT '类别id',
    category_name VARCHAR(255) NOT NULL COMMENT '类别名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '分类表';

-- 创建文章表
DROP TABLE IF EXISTS Cr_Article;
CREATE TABLE Cr_Article
(
    article_id     INT AUTO_INCREMENT PRIMARY KEY COMMENT '文章id',
    title          VARCHAR(255) NOT NULL COMMENT '标题',
    content        TEXT         NOT NULL COMMENT '文章内容',
    author_id      INT COMMENT '作者id',
    category_id    INT COMMENT '类别id',
    published_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
    views          INT       DEFAULT 0 COMMENT '浏览次数',
    likes          INT       DEFAULT 0 COMMENT '点赞数',
    featured       BOOLEAN   DEFAULT FALSE COMMENT '是否为精选文章',
    FOREIGN KEY (author_id) REFERENCES Cr_User (user_id),
    FOREIGN KEY (category_id) REFERENCES Cr_Categorie (category_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '文章表';

-- 创建评论表
DROP TABLE IF EXISTS Cr_Comment;
CREATE TABLE Cr_Comment
(
    comment_id        INT AUTO_INCREMENT PRIMARY KEY COMMENT '评论id',
    article_id        INT COMMENT '文章id',
    user_id           INT COMMENT '用户id',
    parent_comment_id INT COMMENT '父级评论的评论id',
    content           TEXT NOT NULL COMMENT '评论内容',
    comment_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
    FOREIGN KEY (article_id) REFERENCES Cr_Article (article_id),
    FOREIGN KEY (user_id) REFERENCES Cr_User (user_id),
    FOREIGN KEY (parent_comment_id) REFERENCES Cr_Comment (comment_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '评论表';