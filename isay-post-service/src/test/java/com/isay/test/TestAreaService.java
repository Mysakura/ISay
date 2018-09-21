package com.isay.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.internetsaying.post.entity.AreaLabel;
import com.internetsaying.post.entity.WorkArea;
import com.internetsaying.post.service.AreaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-core.xml"})
public class TestAreaService {

	@Autowired
	@Qualifier("areaService")
	private AreaService areaService;
	
	@Test
	public void testLambda() {
		List<String> list = new ArrayList<>();
		list.forEach(s -> System.out.println(s));
	}
	
	@Test
	public void labels() {
		StringBuilder sb = new StringBuilder("Java C++ PHP 数据挖掘 搜索算法 精准推荐 C C# 全栈工程师 .NET Hadoop Python Delphi VB Perl Ruby Node.js Go ASP Shell 后端开发其它 ");
		sb.append("web前端 Flash html5 JavaScript U3D COCOS2D-X 前端开发其它 ");
		sb.append("HTML5 Android iOS WP 移动开发其它 ");
		sb.append("人工智能 深度学习 机器学习 图像处理 图像识别 语音识别 机器视觉 算法工程师 自然语言处理 ");
		sb.append("测试工程师 自动化测试 功能测试 性能测试 测试开发 游戏测试 白盒测试 灰盒测试 黑盒测试 手机测试 硬件测试 测试经理 测试其它 ");
		sb.append("运维工程师 运维开发工程师 网络工程师 系统工程师 IT支持 IDC CDN F5 系统管理员 病毒分析 WEB安全 网络安全 系统安全 运维经理 运维其它 ");
		sb.append("MySQL SQLServer Oracle DB2 MongoDB ETL Hive 数据仓库 DBA其它 ");
		sb.append("技术经理 技术总监 架构师 CTO 运维总监 技术合伙人 项目总监 测试总监 安全专家 ");
		sb.append("项目经理 项目助理 ");
		sb.append("硬件 嵌入式 自动化 单片机 电路设计 驱动开发 系统集成 FPGA开发 DSP开发 ARM开发 PCB工艺 模具设计 热传导 材料工程师 精益工程师 射频工程师 ");
		sb.append("实施工程师 售前工程师 售后工程师 BI工程师");
		String s1 = sb.toString();
		String[] a1 = s1.split(" ");
		System.out.println(s1);
		System.out.println(a1.length);
		
		sb = new StringBuilder("产品经理 网页产品经理 移动产品经理 产品助理 数据产品经理 电商产品经理 游戏策划 产品实习生 ");
		sb.append("网页产品设计师 无线产品设计师 ");
		sb.append("产品部经理 产品总监 游戏制作人");
		String s2 = sb.toString();
		String[] a2 = s2.split(" ");
		System.out.println(s2);
		System.out.println(a2.length);
		
		sb = new StringBuilder("视觉设计师 网页设计师 Flash设计师 APP设计师 UI设计师 平面设计师 美术设计师（2D/3D） 广告设计师 多媒体设计师 原画师 游戏特效 游戏界面设计师 游戏场景 游戏角色 游戏动作 ");
		sb.append("交互设计师 无线交互设计师 网页交互设计师 硬件交互设计师 ");
		sb.append("数据分析师 用户研究员 游戏数值策划 ");
		sb.append("设计经理/主管 设计总监 视觉设计经理/主管 视觉设计总监 交互设计经理/主管 交互设计总监 用户研究经理/主管 用户研究总监");
		String s3 = sb.toString();
		String[] a3 = s3.split(" ");
		System.out.println(s3);
		System.out.println(a3.length);
		
		sb = new StringBuilder("用户运营 产品运营 数据运营 内容运营 活动运营 商家运营 品类运营 游戏运营 网络推广 运营专员 网店运营 新媒体运营 海外运营 运营经理 ");
		sb.append("副主编 内容编辑 文案策划 记者 ");
		sb.append("售前咨询 售后客服 淘宝客服 客服经理 ");
		sb.append("主编 运营总监 COO 客服总监");
		String s4 = sb.toString();
		String[] a4 = s4.split(" ");
		System.out.println(s4);
		System.out.println(a4.length);
		
		sb = new StringBuilder("市场营销 市场策划 市场顾问 市场推广 SEO SEM 商务渠道 商业数据分析 活动策划 网络营销 海外市场 政府关系 ");
		sb.append("媒介经理 广告协调 品牌公关 ");
		sb.append("销售专员 销售经理 客户代表 大客户代表 BD经理 商务渠道 渠道销售 代理商销售 销售助理 电话销售 销售顾问 商品经理 ");
		sb.append("物流 仓储 ");
		sb.append("采购专员 采购经理 商品经理 ");
		sb.append("分析师 投资顾问 投资经理 ");
		sb.append("市场总监 销售总监 商务总监 CMO 公关总监 采购总监 投资总监");
		String s5 = sb.toString();
		String[] a5 = s5.split(" ");
		System.out.println(s5);
		System.out.println(a5.length);
		
		sb = new StringBuilder("人力资源 招聘 HRBP 人事/HR 培训经理 薪资福利经理 绩效考核经理 员工关系 ");
		sb.append("助理 前台 行政 总助 文秘 ");
		sb.append("会计 出纳 财务 结算 税务 审计 风控 ");
		sb.append("法务 律师 专利 ");
		sb.append("行政总监/经理 财务总监/经理 HRD/HRM CFO CEO");
		String s6 = sb.toString();
		String[] a6 = s6.split(" ");
		System.out.println(s6);
		System.out.println(a6.length);
		
		sb = new StringBuilder("投资经理 分析师 投资助理 融资 并购 行业研究 投资者关系 资产管理 理财顾问 交易员 ");
		sb.append("风控 资信评估 合规稽查 律师 ");
		sb.append("审计 法务 会计 清算 ");
		sb.append("投资总监 融资总监 并购总监 风控总监 副总裁");
		String s7 = sb.toString();
		String[] a7 = s7.split(" ");
		System.out.println(s7);
		System.out.println(a7.length);
		
		List<AreaLabel> label = new ArrayList<>();
		for (String s : a1) {
			label.add(new AreaLabel(s, new WorkArea(1)));
		}
		for (String s : a2) {
			label.add(new AreaLabel(s, new WorkArea(2)));
		}
		for (String s : a3) {
			label.add(new AreaLabel(s, new WorkArea(3)));
		}
		for (String s : a4) {
			label.add(new AreaLabel(s, new WorkArea(4)));
		}
		for (String s : a5) {
			label.add(new AreaLabel(s, new WorkArea(5)));
		}
		for (String s : a6) {
			label.add(new AreaLabel(s, new WorkArea(6)));
		}
		for (String s : a7) {
			label.add(new AreaLabel(s, new WorkArea(7)));
		}
		int res = areaService.addAreaLabel(label);
		System.out.println("ADD:" + res);
	}
	
	@Test
	public void testAdd() {
		List<WorkArea> area = new ArrayList<>();
		area.add(new WorkArea("技术"));
		area.add(new WorkArea("产品"));
		area.add(new WorkArea("设计"));
		area.add(new WorkArea("运营"));
		area.add(new WorkArea("市场"));
		area.add(new WorkArea("职能"));
		area.add(new WorkArea("金融"));
		int res = areaService.addArea(area);
		System.out.println(res);
	}
	
	@Test
	public void testUpdate() {
		int res = areaService.updateArea(new WorkArea(1, "Technology"));
		System.out.println(res);
	}
	
	@Test
	public void testDel() {
		
	}
	
	@Test
	public void testAreas() {
		areaService.getAreas().forEach(System.out::println);
	}
	
	@Test
	public void testAddLabel() {
		List<AreaLabel> label = new ArrayList<>();
		String str = "Java C++ PHP 数据挖掘 搜索算法 精准推荐 C C# 全栈工程师 .NET Hadoop Python Delphi VB Perl Ruby Node.js Go ASP Shell";
		String[] strings = str.split(" ");
		System.out.println(strings.length);
		for (String s : strings) {
			label.add(new AreaLabel(s, new WorkArea(8)));
		}
		int res = areaService.addAreaLabel(label);
		System.out.println(res);
	}
	
	@Test
	public void testUpdateLabel() {
		int res = areaService.updateAreaLabel(new AreaLabel(7, "C语言"));
		System.out.println(res);
	}
	
	@Test
	public void testDelLabel() {
		
	}
	
	@Test
	public void testLabels() {
		areaService.getAreaLabel(1).forEach(System.out::println);
	}
	
}
