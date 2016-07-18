<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="Description" content="">
<meta name="Keywords" content="">
<title>搜索功能</title>

<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.enplaceholder.js" type="text/javascript" charset="utf-8"></script>
<script src="js/base.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/sea.js"></script>
<script type="text/javascript" src="js/base(1).js"></script>
<script src="js/MD5.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery-validate-1.12.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/validate-common.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/check_reg.js"></script>
<script src="js/jquery.pagination.js" type="text/javascript"></script>
<script type="text/javascript">

	$(
			function() {
				//初始化时设置样式-项目领域
				var industryId = $("#industryId").val();
				if ($("#industryUL li a[value='" + industryId + "']").size() > 0) {
					$("#industryUL li a").removeClass("active");
					$("#industryUL li a[value='" + industryId + "']").addClass(
							"active");
				}
				;
				//初始化时设置样式-融资阶段
				var stageId = $("#stageId").val();
				if ($("#stageUL li a[value='" + stageId + "']").size() > 0) {
					$("#stageUL li a").removeClass("active");
					$("#stageUL li a[value='" + stageId + "']").addClass(
							"active");
				}
				;

				//注册事件-项目领域
				$("#industryUL li a").click(
						function() {
							var industryId = $(this).attr("value");
							if ($("#industryUL li a[value='" + industryId + "']").size() > 0) {
								$("#industryUL li a").removeClass("active");
								$("#industryUL li a[value='" + industryId + "']").addClass("active");
								$("#industryId").val(industryId);
								$("#searchform").submit();
							}
						});
				//注册事件-融资阶段
				$("#stageUL li a").click(
						function() {
							var industryId = $(this).attr("value");
							if ($("#stageUL li a[value='" + industryId + "']").size() > 0) {
								$("#stageUL li a").removeClass("active");
								$("#stageUL li a[value='" + industryId + "']").addClass("active");
								$("#stageId").val(industryId);
								$("#searchform").submit();
							}
						});

			})
</script>

</head>

<body>

	
<!--头部-->
<c:import url="header.jsp"/>
<!--end 头部-->
	<div class="content">
		<!--内容区-->
		<div class="srh-wp-box">
			<div class="wrap">
				<form action="" id="searchform" method="post">
					<input type="hidden" id="page" name="page" value="1">
					<div class="screen-box">
						<div class="sl-wrap clearfix">
							<div class="sl-key">所属领域：</div>
							<div class="sl-value">
								<div class="sl-v-list">
									<ul class="valueList" id="industryUL">
										<input id="industryId" type="hidden" name="industryId" value="${empty param.industryId?-1:param.industryId}">
										<li><a value="-1" title="不限" class="active" href="javascript:void(0);">不限</a></li>

										<li><a value="1" title="电子商务" href="javascript:void(0);">电子商务</a></li>

										<li><a value="2" title="社交网络" href="javascript:void(0);">社交网络</a></li>

										<li><a value="3" title="智能硬件" href="javascript:void(0);">智能硬件</a></li>

										<li><a value="4" title="媒体门户" href="javascript:void(0);">媒体门户</a></li>

										<li><a value="5" title="工具软件" href="javascript:void(0);">工具软件</a></li>

										<li><a value="6" title="消费生活" href="javascript:void(0);">消费生活</a></li>

										<li><a value="7" title="金融" href="javascript:void(0);">金融</a></li>

										<li><a value="8" title="医疗健康" href="javascript:void(0);">医疗健康</a></li>

										<li><a value="9" title="企业服务" href="javascript:void(0);">企业服务</a></li>

										<li><a value="10" title="旅游户外" href="javascript:void(0);">旅游户外</a></li>

										<li><a value="11" title="房产家居" href="javascript:void(0);">房产家居</a></li>

										<li><a value="12" title="数字娱乐" href="javascript:void(0);">数字娱乐</a></li>

										<li><a value="13" title="教育" href="javascript:void(0);">教育</a></li>

										<li><a value="14" title="汽车交通" href="javascript:void(0);">汽车交通</a></li>

										<li><a value="15" title="物流" href="javascript:void(0);">物流</a></li>

										<li><a value="16" title="农林牧渔" href="javascript:void(0);">农林牧渔</a></li>

										<li><a value="17" title="节能环保" href="javascript:void(0);">节能环保</a></li>

										<li><a value="18" title="军工" href="javascript:void(0);">军工</a></li>

										<li><a value="19" title="先进制造/工业自动化"
											href="javascript:void(0);">先进制造/工业自动化</a></li>

										<li><a value="20" title="人力资源服务"
											href="javascript:void(0);">人力资源服务</a></li>
									</ul>
								</div>
							</div>
							<div class="sl-ext">
								<span><em>更多</em><i class="icon"></i></span>
							</div>
						</div>
						<div class="sl-wrap clearfix">
							<div class="sl-key">融资阶段：</div>
							<div class="sl-value">
								<div class="sl-v-list">
									<ul class="valueList" id="stageUL">
										<input type="hidden" name="stageId" id="stageId" value="${empty param.stageId?-1:param.stageId}">
										<li><a value="-1" title="不限" class="active" href="javascript:void(0);">不限</a></li>
										<li><a value="1" title="天使轮" href="javascript:void(0);">天使轮</a></li>
										<li><a value="2" title="A轮" href="javascript:void(0);">A轮</a></li>
										<li><a value="3" title="B轮" href="javascript:void(0);">B轮</a></li>
										<li><a value="4" title="C轮" href="javascript:void(0);">C轮</a></li>
										<li><a value="5" title="D轮" href="javascript:void(0);">D轮</a></li>
										<li><a value="6" title="E轮及以后" href="javascript:void(0);">E轮及以后</a></li>
										<li><a value="7" title="未融资" href="javascript:void(0);">未融资</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="sl-wrap clearfix">
							<div class="sl-key">产品类别：</div>
							<div class="sl-value">
								<div class="sl-v-list">
									<ul class="valueList" id="typeUL">
										<input type="hidden" name="typeId" id="typeId" value="${empty param.typeId?-1:param.typeId}">
										<li><a value="-1" title="不限" class="active" href="javascript:void(0);">不限</a></li>
										<li><a value="1" title="硬件" href="javascript:void(0);">硬件</a></li>
										<li><a value="2" title="App" href="javascript:void(0);">App</a></li>
										<li><a value="3" title="网站（含PC侧和移动侧）" href="javascript:void(0);">网站（含PC侧和移动侧）</a></li>
										<li><a value="4" title="软件（特定的PC客户端）" href="javascript:void(0);">软件（特定的PC客户端）</a></li>
										<li><a value="5" title="微信公众号" href="javascript:void(0);">微信公众号</a></li>
										<li><a value="6" title="线下实体"	href="javascript:void(0);">线下实体</a></li>
										<li><a value="99" title="其他" href="javascript:void(0);">其他</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="sl-wrap clearfix">
							<div class="sl-key">
								地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区：</div>
							<div class="sl-value">
								<div class="sl-v-list">
									<ul class="valueList" id="locationUL">
										<!-- <input type="hidden" name="locationid" id="locationid"> -->
										<li><a class="active" href="javascript:void(0);">不限</a></li>
										<li><a value="110000" title="北京市"
											href="javascript:void(0);">北京市</a></li>
										<li><a value="120000" title="天津市"
											href="javascript:void(0);">天津市</a></li>
										<li><a value="130000" title="河北省"
											href="javascript:void(0);">河北省</a></li>
										<li><a value="140000" title="山西省"
											href="javascript:void(0);">山西省</a></li>
										<li><a value="150000" title="内蒙古自治区"
											href="javascript:void(0);">内蒙古自治区</a></li>
										<li><a value="210000" title="辽宁省"
											href="javascript:void(0);">辽宁省</a></li>
										<li><a value="220000" title="吉林省"
											href="javascript:void(0);">吉林省</a></li>
										<li><a value="230000" title="黑龙江省"
											href="javascript:void(0);">黑龙江省</a></li>
										<li><a value="310000" title="上海市"
											href="javascript:void(0);">上海市</a></li>
										<li><a value="320000" title="江苏省"
											href="javascript:void(0);">江苏省</a></li>
										<li><a value="330000" title="浙江省"
											href="javascript:void(0);">浙江省</a></li>
										<li><a value="340000" title="安徽省"
											href="javascript:void(0);">安徽省</a></li>
										<li><a value="350000" title="福建省"
											href="javascript:void(0);">福建省</a></li>
										<li><a value="360000" title="江西省"
											href="javascript:void(0);">江西省</a></li>
										<li><a value="370000" title="山东省"
											href="javascript:void(0);">山东省</a></li>
										<li><a value="410000" title="河南省"
											href="javascript:void(0);">河南省</a></li>
										<li><a value="420000" title="湖北省"
											href="javascript:void(0);">湖北省</a></li>
										<li><a value="430000" title="湖南省"
											href="javascript:void(0);">湖南省</a></li>
										<li><a value="440000" title="广东省"
											href="javascript:void(0);">广东省</a></li>
										<li><a value="450000" title="广西壮族自治区"
											href="javascript:void(0);">广西壮族自治区</a></li>
										<li><a value="460000" title="海南省"
											href="javascript:void(0);">海南省</a></li>
										<li><a value="500000" title="重庆市"
											href="javascript:void(0);">重庆市</a></li>
										<li><a value="510000" title="四川省"
											href="javascript:void(0);">四川省</a></li>
										<li><a value="520000" title="贵州省"
											href="javascript:void(0);">贵州省</a></li>
										<li><a value="530000" title="云南省"
											href="javascript:void(0);">云南省</a></li>
										<li><a value="540000" title="西藏自治区"
											href="javascript:void(0);">西藏自治区</a></li>
										<li><a value="610000" title="陕西省"
											href="javascript:void(0);">陕西省</a></li>
										<li><a value="620000" title="甘肃省"
											href="javascript:void(0);">甘肃省</a></li>
										<li><a value="630000" title="青海省"
											href="javascript:void(0);">青海省</a></li>
										<li><a value="640000" title="宁夏回族自治区"
											href="javascript:void(0);">宁夏回族自治区</a></li>
										<li><a value="650000" title="新疆维吾尔自治区"
											href="javascript:void(0);">新疆维吾尔自治区</a></li>
										<li><a value="710000" title="台湾省"
											href="javascript:void(0);">台湾省</a></li>
										<li><a value="810000" title="香港特别行政区"
											href="javascript:void(0);">香港特别行政区</a></li>
										<li><a value="820000" title="澳门特别行政区"
											href="javascript:void(0);">澳门特别行政区</a></li>
										<li><a value="659000" title="新疆生产建设兵团"
											href="javascript:void(0);">新疆生产建设兵团</a></li>
									</ul>
								</div>
							</div>
							<div class="sl-ext">
								<span><em>更多</em><i class="icon"></i></span>
							</div>
						</div>
						<div class="sl-wrap clearfix no-border">
							<div class="sl-key">
								搜&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;索：</div>
							<div class="sl-value">
								<div class="sl-v-list">
									<div class="sl-search">
										<!-- <input class="ipt-txt" type="text" name="itemname"> -->
										<button class="sl-search-btn" onclick="return false;"></button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
				<div class="tab">
					<ul class="tabs-list clearfix">
						<li>
							<div class="hd">
								<p class="phot">
									<img src="images/a43e4bfc883d41a2a8ebc271c87453e0.jpg" width="375" height="200">
								</p>
							</div>
							<div class="bd">
								<p class="name">
									<a href="javascript:void(0);">绿源生物农药</a><i class="invest_ico_gray"></i>
								</p>
								<p class="tits">山东师范大学</p>
								<p class="weal">
									<a javascript:void(0);="" class="one">网站（含PC侧和移动侧）</a>
									<a javascript:void(0);="" class="one">微信公众号</a> 
									<a javascript:void(0);="" class="one">线下实体</a>
								</p>
								<p class="link">
									<a javascript:void(0);="">
									绿源生物科技有限责任公司历时多年成功研发出绿源生物农药，并拥有成熟的生产技术。
									本产品由生防黄绿木霉（Trichoderma+aureoviride）、棘孢木霉（Trichoderma+asperell
									... </a>
								</p>
							</div>
						</li>

					</ul>
				</div>
				<div class="paging">
				<div class="paging-box">
					<ul>
						<li><a title="上一页" href="javascript:void(0);">&lt;&lt;</a></li>
						<li><a href="javascript:void(0);">1</a></li>
						<li><a href="javascript:void(0);">2</a></li>
						<li><a href="javascript:void(0);">3</a></li>
						<li><a class="active" href="javascript:void(0);">4</a></li>
						<li><a href="javascript:void(0);">5</a></li>
						<li><a href="javascript:void(0);">6</a></li>
						<li><a href="javascript:void(0);">7</a></li>
						<li><a href="javascript:void(0);">8</a></li>
						<li><a title="下一页" href="javascript:void(0);">&gt;&gt;</a></li>
					</ul>
				</div>
			</div>
				<!--end 分页-->

			</div>
		</div>
		<!--srh-wp-box End-->
		<!--end 内容区-->
	</div>

	<!--底部-->
	<c:import url="/footer.jsp"/>
</body>
</html>
