/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : isay_site

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-09-21 10:44:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for about
-- ----------------------------
DROP TABLE IF EXISTS `about`;
CREATE TABLE `about` (
  `about_id` char(20) NOT NULL,
  `about_content` text NOT NULL,
  `about_markdown` text NOT NULL,
  `about_type` enum('1','2','3') NOT NULL DEFAULT '1' COMMENT '''1-关于站点；2-关于作者；3-联系方式''',
  `editor_id` char(32) NOT NULL,
  `about_time` datetime NOT NULL,
  PRIMARY KEY (`about_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of about
-- ----------------------------
INSERT INTO `about` VALUES ('1', '<h3 id=\"h3--codes\"><a name=\"多语言代码高亮 Codes\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>多语言代码高亮 Codes</h3><h4 id=\"h4--inline-code\"><a name=\"行内代码 Inline code\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>行内代码 Inline code</h4><p>执行命令：<code>npm install marked</code></p>\r\n<h4 id=\"h4-u7F29u8FDBu98CEu683C\"><a name=\"缩进风格\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>缩进风格</h4><p>即缩进四个空格，也做为实现类似 <code>&lt;pre&gt;</code> 预格式化文本 ( Preformatted Text ) 的功能。</p>\r\n<pre><code>&lt;?php\r\n    echo \"Hello world!\";\r\n?&gt;\r\n</code></pre><p>预格式化文本：</p>\r\n<pre><code>| First Header  | Second Header |\r\n| ------------- | ------------- |\r\n| Content Cell  | Content Cell  |\r\n| Content Cell  | Content Cell  |\r\n</code></pre><h4 id=\"h4-js-\"><a name=\"JS代码\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>JS代码　</h4><pre><code class=\"lang-javascript\">function test() {\r\n    console.log(\"Hello world!\");\r\n}\r\n\r\n(function(){\r\n    var box = function() {\r\n        return box.fn.init();\r\n    };\r\n\r\n    box.prototype = box.fn = {\r\n        init : function(){\r\n            console.log(\'box.init()\');\r\n\r\n            return this;\r\n        },\r\n\r\n        add : function(str) {\r\n            alert(\"add\", str);\r\n\r\n            return this;\r\n        },\r\n\r\n        remove : function(str) {\r\n            alert(\"remove\", str);\r\n\r\n            return this;\r\n        }\r\n    };\r\n\r\n    box.fn.init.prototype = box.fn;\r\n\r\n    window.box =box;\r\n})();\r\n\r\nvar testBox = box();\r\ntestBox.add(\"jQuery\").remove(\"jQuery\");\r\n</code></pre>', '\r\n### 多语言代码高亮 Codes\r\n\r\n#### 行内代码 Inline code\r\n\r\n执行命令：`npm install marked`\r\n\r\n#### 缩进风格\r\n\r\n即缩进四个空格，也做为实现类似 `<pre>` 预格式化文本 ( Preformatted Text ) 的功能。\r\n\r\n    <?php\r\n        echo \"Hello world!\";\r\n    ?>\r\n    \r\n预格式化文本：\r\n\r\n    | First Header  | Second Header |\r\n    | ------------- | ------------- |\r\n    | Content Cell  | Content Cell  |\r\n    | Content Cell  | Content Cell  |\r\n\r\n#### JS代码　\r\n\r\n```javascript\r\nfunction test() {\r\n	console.log(\"Hello world!\");\r\n}\r\n \r\n(function(){\r\n    var box = function() {\r\n        return box.fn.init();\r\n    };\r\n\r\n    box.prototype = box.fn = {\r\n        init : function(){\r\n            console.log(\'box.init()\');\r\n\r\n			return this;\r\n        },\r\n\r\n		add : function(str) {\r\n			alert(\"add\", str);\r\n\r\n			return this;\r\n		},\r\n\r\n		remove : function(str) {\r\n			alert(\"remove\", str);\r\n\r\n			return this;\r\n		}\r\n    };\r\n    \r\n    box.fn.init.prototype = box.fn;\r\n    \r\n    window.box =box;\r\n})();\r\n\r\nvar testBox = box();\r\ntestBox.add(\"jQuery\").remove(\"jQuery\");\r\n```\r\n', '1', '15248859107335YA2M37', '2018-04-29 16:19:41');
INSERT INTO `about` VALUES ('1528164218176ZS695SK', '<h3 id=\"h3-u7075u611Fu6765u6E90\"><a name=\"灵感来源\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>灵感来源</h3><p>作者在求职过程中遇到了很多困惑，比如简历的包装、面试的技巧等，并不是说你专业很强就一定能得到橄榄枝。所以想写个网站，就想为大学生提供求职的帮助。</p>\r\n<h3 id=\"h3-u53D1u5C55u5386u53F2\"><a name=\"发展历史\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>发展历史</h3><p>最初的想法是在2017年暑假，因为那个时候准备秋招，可惜连连失败。</p>\r\n<p>2017-07 在家里学习了分布式服务框架，为本网站的架构打下了基础。</p>\r\n<p>2017-08~2017-12 主要工作在开发前台界面，说实话前台界面是很费时间的</p>\r\n<p>2018-01 开始进入后台开发阶段，因为用到的技术比较多，所以困难是有的，但是最终都被我一一解决。</p>\r\n<p>2018-05 开发完毕，也算完成了我大学的最后一个想法。</p>\r\n', '\r\n### 灵感来源\r\n作者在求职过程中遇到了很多困惑，比如简历的包装、面试的技巧等，并不是说你专业很强就一定能得到橄榄枝。所以想写个网站，就想为大学生提供求职的帮助。\r\n\r\n### 发展历史\r\n\r\n最初的想法是在2017年暑假，因为那个时候准备秋招，可惜连连失败。\r\n\r\n2017-07 在家里学习了分布式服务框架，为本网站的架构打下了基础。\r\n\r\n2017-08~2017-12 主要工作在开发前台界面，说实话前台界面是很费时间的\r\n\r\n2018-01 开始进入后台开发阶段，因为用到的技术比较多，所以困难是有的，但是最终都被我一一解决。\r\n\r\n2018-05 开发完毕，也算完成了我大学的最后一个想法。', '1', '1526179403208IWBRWA6', '2018-06-05 10:03:38');
INSERT INTO `about` VALUES ('2', '<h4 id=\"h4-html-html-codes\"><a name=\"HTML 代码 HTML codes\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>HTML 代码 HTML codes</h4><pre><code class=\"lang-html\">&lt;!DOCTYPE html&gt;\r\n&lt;html&gt;\r\n    &lt;head&gt;\r\n        &lt;mate charest=\"utf-8\" /&gt;\r\n        &lt;meta name=\"keywords\" content=\"Editor.md, Markdown, Editor\" /&gt;\r\n        &lt;title&gt;Hello world!&lt;/title&gt;\r\n        &lt;style type=\"text/css\"&gt;\r\n            body{font-size:14px;color:#444;font-family: \"Microsoft Yahei\", Tahoma, \"Hiragino Sans GB\", Arial;background:#fff;}\r\n            ul{list-style: none;}\r\n            img{border:none;vertical-align: middle;}\r\n        &lt;/style&gt;\r\n    &lt;/head&gt;\r\n    &lt;body&gt;\r\n        &lt;h1 class=\"text-xxl\"&gt;Hello world!&lt;/h1&gt;\r\n        &lt;p class=\"text-green\"&gt;Plain text&lt;/p&gt;\r\n    &lt;/body&gt;\r\n&lt;/html&gt;\r\n</code></pre>\r\n<h3 id=\"h3--images\"><a name=\"图片 Images\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>图片 Images</h3><p>Image:</p>\r\n<p><img src=\"https://pandao.github.io/editor.md/examples/images/4.jpg\" alt=\"\">\r\n<blockquote>\r\n<p>Follow your heart.</p>\r\n</blockquote>', '#### HTML 代码 HTML codes\r\n\r\n```html\r\n<!DOCTYPE html>\r\n<html>\r\n    <head>\r\n        <mate charest=\"utf-8\" />\r\n        <meta name=\"keywords\" content=\"Editor.md, Markdown, Editor\" />\r\n        <title>Hello world!</title>\r\n        <style type=\"text/css\">\r\n            body{font-size:14px;color:#444;font-family: \"Microsoft Yahei\", Tahoma, \"Hiragino Sans GB\", Arial;background:#fff;}\r\n            ul{list-style: none;}\r\n            img{border:none;vertical-align: middle;}\r\n        </style>\r\n    </head>\r\n    <body>\r\n        <h1 class=\"text-xxl\">Hello world!</h1>\r\n        <p class=\"text-green\">Plain text</p>\r\n    </body>\r\n</html>\r\n```\r\n\r\n### 图片 Images\r\n\r\nImage:\r\n\r\n![](https://pandao.github.io/editor.md/examples/images/4.jpg)\r\n\r\n> Follow your heart.', '2', '15248859107335YA2M37', '2018-04-29 16:31:07');
INSERT INTO `about` VALUES ('3', '<hr style=\"page-break-after:always;\" class=\"page-break editormd-page-break\" /><h3 id=\"h3--tex-katex-\"><a name=\"科学公式 TeX(KaTeX)\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>科学公式 TeX(KaTeX)</h3><p class=\"editormd-tex\">E=mc^2</p>\r\n<p>行内的公式<span class=\"editormd-tex\">E=mc^2</span>行内的公式，行内的<span class=\"editormd-tex\">E=mc^2</span>公式。</p>\r\n<p class=\"editormd-tex\">x &gt; y</p>\r\n<p class=\"editormd-tex\">(\\sqrt{3x-1}+(1+x)^2)</p>\r\n<p class=\"editormd-tex\">\\sin(\\alpha)^{\\theta}=\\sum_{i=0}^{n}(x^i + \\cos(f))</p>\r\n<p>多行公式：</p>\r\n<p class=\"editormd-tex\">\\displaystyle\r\n\\left( \\sum\\_{k=1}^n a\\_k b\\_k \\right)^2\r\n\\leq\r\n\\left( \\sum\\_{k=1}^n a\\_k^2 \\right)\r\n\\left( \\sum\\_{k=1}^n b\\_k^2 \\right)</p><p class=\"editormd-tex\">\\displaystyle \r\n    \\frac{1}{\r\n        \\Bigl(\\sqrt{\\phi \\sqrt{5}}-\\phi\\Bigr) e^{\r\n        \\frac25 \\pi}} = 1+\\frac{e^{-2\\pi}} {1+\\frac{e^{-4\\pi}} {\r\n        1+\\frac{e^{-6\\pi}}\r\n        {1+\\frac{e^{-8\\pi}}\r\n         {1+\\cdots} }\r\n        } \r\n    }</p><p class=\"editormd-tex\">f(x) = \\int_{-\\infty}^\\infty\r\n    \\hat f(\\xi)\\,e^{2 \\pi i \\xi x}\r\n    \\,d\\xi</p><h3 id=\"h3--page-break\"><a name=\"分页符 Page break\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>分页符 Page break</h3><blockquote>\r\n<p>Print Test: Ctrl + P</p>\r\n</blockquote>\r\n<hr style=\"page-break-after:always;\" class=\"page-break editormd-page-break\" />', '[========]\r\n            \r\n### 科学公式 TeX(KaTeX)\r\n\r\n$$E=mc^2$$\r\n\r\n行内的公式$$E=mc^2$$行内的公式，行内的$$E=mc^2$$公式。\r\n\r\n$$x > y$$\r\n\r\n$$\\(\\sqrt{3x-1}+(1+x)^2\\)$$\r\n                    \r\n$$\\sin(\\alpha)^{\\theta}=\\sum_{i=0}^{n}(x^i + \\cos(f))$$\r\n\r\n多行公式：\r\n\r\n```math\r\n\\displaystyle\r\n\\left( \\sum\\_{k=1}^n a\\_k b\\_k \\right)^2\r\n\\leq\r\n\\left( \\sum\\_{k=1}^n a\\_k^2 \\right)\r\n\\left( \\sum\\_{k=1}^n b\\_k^2 \\right)\r\n```\r\n\r\n```katex\r\n\\displaystyle \r\n    \\frac{1}{\r\n        \\Bigl(\\sqrt{\\phi \\sqrt{5}}-\\phi\\Bigr) e^{\r\n        \\frac25 \\pi}} = 1+\\frac{e^{-2\\pi}} {1+\\frac{e^{-4\\pi}} {\r\n        1+\\frac{e^{-6\\pi}}\r\n        {1+\\frac{e^{-8\\pi}}\r\n         {1+\\cdots} }\r\n        } \r\n    }\r\n```\r\n\r\n```latex\r\nf(x) = \\int_{-\\infty}^\\infty\r\n    \\hat f(\\xi)\\,e^{2 \\pi i \\xi x}\r\n    \\,d\\xi\r\n```\r\n\r\n### 分页符 Page break\r\n\r\n> Print Test: Ctrl + P\r\n\r\n[========]\r\n', '3', '15248859107335YA2M37', '2018-04-29 16:32:47');

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `ann_id` char(20) NOT NULL,
  `ann_title` varchar(255) NOT NULL,
  `ann_content` text NOT NULL,
  `ann_markdown` text NOT NULL,
  `editor_id` char(32) NOT NULL,
  `ann_time` datetime NOT NULL,
  PRIMARY KEY (`ann_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('15281659548392WRX6FA', '互联网说终于开发完成啦', '<h3 id=\"h3-u5F00u53D1u5B8Cu4E86u5C31u662Fu5B8Cu4E86\"><a name=\"开发完了就是完了\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>开发完了就是完了</h3>', '### 开发完了就是完了', '1526179403208IWBRWA6', '2018-06-05 10:32:35');

-- ----------------------------
-- Table structure for friend_link
-- ----------------------------
DROP TABLE IF EXISTS `friend_link`;
CREATE TABLE `friend_link` (
  `fl_id` char(20) NOT NULL,
  `fl_url` varchar(255) NOT NULL,
  `fl_name` varchar(25) NOT NULL,
  `fl_ok` enum('0','1','2') NOT NULL DEFAULT '0' COMMENT '''0-未处理；1-不通过；2-通过''',
  `fl_user_id` char(32) NOT NULL COMMENT '''申请者''',
  `fl_admin_id` char(32) NOT NULL DEFAULT '' COMMENT '''同意者或者拒绝者''',
  `fl_time` datetime NOT NULL,
  PRIMARY KEY (`fl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend_link
-- ----------------------------
INSERT INTO `friend_link` VALUES ('1524914762715TPYZD3M', 'http://www/cjs.com', '巢急送', '2', '15248859107335YA2M37', '1526179403208IWBRWA6', '2018-04-28 19:26:03');
INSERT INTO `friend_link` VALUES ('15249868258445BML3XY', 'http://www.hebut.edu.cn/', '河北工业大学', '2', '15248859107335YA2M37', '1526179403208IWBRWA6', '2018-04-29 15:27:06');
INSERT INTO `friend_link` VALUES ('1525941073691ZFEMCY4', 'http://www.qwe.com', '是是是', '1', '15248859107335YA2M37', '1526179403208IWBRWA6', '2018-05-10 16:31:14');

-- ----------------------------
-- Table structure for message_board
-- ----------------------------
DROP TABLE IF EXISTS `message_board`;
CREATE TABLE `message_board` (
  `message_id` char(20) NOT NULL,
  `message_content` varchar(1024) NOT NULL,
  `message_time` datetime NOT NULL,
  `user_id` char(32) NOT NULL,
  `reply_num` int(11) NOT NULL DEFAULT '0' COMMENT '''回复数目，每当有回复，就利用触发器给对应的回复数目+1''',
  `is_delete` enum('0','1') NOT NULL DEFAULT '0' COMMENT '''0-未删除；1-已删除''',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='留言板';

-- ----------------------------
-- Records of message_board
-- ----------------------------
INSERT INTO `message_board` VALUES ('15259212118449N1KFP7', '是否更舒服', '2018-05-10 11:00:12', '15248859107335YA2M37', '0', '1');
INSERT INTO `message_board` VALUES ('1525921529649XYLRHS2', '<div>谢谢你如此温柔</div><div>捧着爱静静等候</div>', '2018-05-10 11:05:30', '15248859107335YA2M37', '0', '0');
INSERT INTO `message_board` VALUES ('1525921667055BUZSWXJ', '<div>不知道 不明了</div><div>不想要 为什么</div><div>我的心</div><div>明明是想靠近 却孤单到黎明</div>', '2018-05-10 11:07:47', '15248859107335YA2M37', '0', '0');
INSERT INTO `message_board` VALUES ('15259218171878NQGX75', '<div>不知道 不明了</div><div>不想要 为什么</div><div>我的心</div><div>那爱情的绮丽 总是在孤单里</div><div>再把我的最好的爱给你</div><div><br></div><img class=\"mr-img\" src=\"http://localhost:8080/isay-web/message_photo/1525921812017.jpg\">', '2018-05-10 11:10:17', '15248859107335YA2M37', '4', '0');
INSERT INTO `message_board` VALUES ('1525941096652TQ9UYWA', 'sgh<img class=\"mr-img\" src=\"http://localhost:8080/isay-web/message_photo/1525941094841.jpg\">', '2018-05-10 16:31:37', '15248859107335YA2M37', '0', '0');

-- ----------------------------
-- Table structure for message_board_reply
-- ----------------------------
DROP TABLE IF EXISTS `message_board_reply`;
CREATE TABLE `message_board_reply` (
  `mr_id` char(20) NOT NULL,
  `mr_content` varchar(1024) NOT NULL,
  `mr_time` datetime NOT NULL,
  `message_id` char(20) NOT NULL,
  `from_user_id` char(32) NOT NULL,
  `to_user_id` char(32) NOT NULL,
  `is_delete` enum('0','1') NOT NULL DEFAULT '0' COMMENT '''0-未删除；1-已删除''',
  PRIMARY KEY (`mr_id`),
  KEY `fk_mr_m` (`message_id`),
  CONSTRAINT `fk_mr_m` FOREIGN KEY (`message_id`) REFERENCES `message_board` (`message_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='留言回复';

-- ----------------------------
-- Records of message_board_reply
-- ----------------------------
INSERT INTO `message_board_reply` VALUES ('1525933615834KPI3TN1', '<div>(女) 回头望 伴你走 从来未曾幸福过</div><div>(男) 恨太多 没结果 往事重提是折磨</div>', '2018-05-10 14:26:56', '15259218171878NQGX75', '15248859107335YA2M37', '15248859107335YA2M37', '0');
INSERT INTO `message_board_reply` VALUES ('15259339468745QRA5TS', '<div>说不上爱别说谎就一点喜欢</div><div>说不上恨别纠缠别装作感叹</div>', '2018-05-10 14:32:27', '15259218171878NQGX75', '15248859107335YA2M37', '15248859107335YA2M37', '0');
INSERT INTO `message_board_reply` VALUES ('15259340972718TIMCIJ', '<img class=\"mr-img\" src=\"http://localhost:8080/isay-web/message_photo/1525934090998.jpg\">', '2018-05-10 14:34:57', '15259218171878NQGX75', '15248859107335YA2M37', '15248859107335YA2M37', '0');
INSERT INTO `message_board_reply` VALUES ('1525941121791AWLK2N7', '<img class=\"mr-img\" src=\"http://localhost:8080/isay-web/message_photo/1525941120984.jpeg\">', '2018-05-10 16:32:02', '15259218171878NQGX75', '15248859107335YA2M37', '15248859107335YA2M37', '1');

-- ----------------------------
-- Table structure for time_line
-- ----------------------------
DROP TABLE IF EXISTS `time_line`;
CREATE TABLE `time_line` (
  `tl_id` char(20) NOT NULL,
  `tl_content` varchar(255) NOT NULL,
  `tl_time` datetime NOT NULL,
  `editor_id` char(32) NOT NULL,
  PRIMARY KEY (`tl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of time_line
-- ----------------------------
INSERT INTO `time_line` VALUES ('1528162929422HNFJRB9', '2017年7月，开始前台界面的开发', '2018-06-05 09:42:09', '1526179403208IWBRWA6');
INSERT INTO `time_line` VALUES ('1528163121566Z4FA9AE', '2018年1月，进行整站需求分析，并定出数据库', '2018-06-05 09:45:22', '1526179403208IWBRWA6');
INSERT INTO `time_line` VALUES ('1528163169638AWTQVSH', '2018年4月，开发频率加快，完成大约一半的功能', '2018-06-05 09:46:10', '1526179403208IWBRWA6');
INSERT INTO `time_line` VALUES ('15281631999338AQDS2M', '2018年5月，完成全部功能，并测试，完善。', '2018-06-05 09:46:40', '1526179403208IWBRWA6');
DROP TRIGGER IF EXISTS `trigger_m_r`;
DELIMITER ;;
CREATE TRIGGER `trigger_m_r` AFTER INSERT ON `message_board_reply` FOR EACH ROW begin

declare c int;
set c = (select reply_num from message_board where message_id = new.message_id);
update message_board set reply_num = c+1 where message_id = new.message_id;

end
;;
DELIMITER ;
