# java-annotation   
注解的使用
      
# 一、什么是注解（annotation）

## 1、注解起源

		注解是怎么来的呢？在很久以前没有注解的年代，程序员使用什么来辅助代码的实现。程序员通过注释的方式来/** */这个方式来辅助代码，然后通过其他的编辑工具来编译注释中的代码。java的官方 sun 公司发现这个现象后，在 jdk5 版本中提出来（cannotation）的使用方式，中文就是称为“注解”。

		java 注解又称为 java 标注，是 java 语言 5.0 版本开始支持加入源代码的特殊语法元数据。
		注解附加在代码中的一些元信息， 用于代码在编译、运行时进行解析和使用，起到了说明、配置的功能。
		注解不会影响代码的实现逻辑，它仅仅起到辅助性的作用。包含在 rt.java.lang.annotation包中。

## 2、 java.lang.annotation包中的元注解

		元注解是指注解的注解
		平常的中我们只要 annotation 包中的四个元注解就可以了：
		
		@Retention
		@Target
		@Document
		@Inherited 

###  2.1 @Retention： 定义注解的保留策略（说白就是这个注解在类加载时能保留多长的时间）
		
		@Retention(RetentionPolicy.SOURCE)	 // 注解仅存在与源码中， 在class 字节码文件中不包含。
		@Retention(RetentionPolicy.CLASS)    // 默认的保留策略，注解会在class 字节文件中保在，但运行时无法获得
		@Retention(RetentionPolicy.RUNTIME)  // 注解会在 class 字节文件中存在，在运行时可以通过反射获取到

		从产生到执行的，会执行的步骤
		加载 --> 检查 --> 准备 --> 解析 --> 初始化
		Xxx.java --javac--> Xxx.class --java--> 机器码执行
### 2.2 @Target：定义注解的作用目标（就是这个注解能放在哪里上使用）

		@Target(ElementType.TYPE)				// 接口、类、枚举、注解
		@Target(ElementType.FIELD)				// 字段、枚举的常量
		@Target(ElementType.METHOD)				// 方法
		@Target(ElementType.PARAMETER)			// 方法参数上
		@Target(ElementType.CONSTRUCTOR)		// 构造函数
		@Target(ElementType.LOCAL_VARIABLE)		// 局部变量
		@Target(ElementType.ANNOTATION_TYPE)	// 注解
		@Target(ElementType.PACKAGE)			// 包

### 2.3 @Documented：说明该注解将被包含在javadoc中

### 2.4 @Inherited：说明子类可以继承父类中的该注解

		
# 二、怎么创建注解 （annotation）

## 1、通过三个方法获取注解上面的内容

	isAnnotationPresent()	// 判断是否有该注解
	getAnnotation()			// 获取注解的方法
	getAnnotations()		//获取多个注解的地址

## 2、创建注解

	1、annotation package

	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	public @interface MyAnn {
	 	String name() default "[^a-z]";	// 定义一个方法不用写,不能写a到z字母小写的
	}
	
	2、entity package

	public class Student {

		@MyAnn(name="张三")
		private String name;

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	3、test package
	
	// 调用注解

	public class Test{
		
		public static void main(String[] args) {
			
			Student stu = new Student();

			stu.setName("进行");

			// 通过反射获取注解
			Field[] declaredFields = Class.forName("com.wgc.myannotation.entity.Student").getDeclaredFields();

			// 循环所有的字段
			for(Filed filed : declaredFilds) {
				
				if (filed.isAnnotationPresent(MyAnn.class)) {
					
					MyAnn ann =	filed.getAnnotation(MyAnn.class);
					
					String regexp = ann.name();

					// matches() 是字符串正则表达式
					if(stu.getName().matches(regexp)) {
						System.out.println("正则表达式匹配正确");
					} else {
						System.out.println("错误");
					}

				}
			}
			
		}
	}

# 三、怎么使用注解 （annotation）

# 四、其他的注解
	
	@Deprecated			// 注明该方法已过时，不建议使用
	@@verride			// 表明覆盖父类的方法
	@SupperssWarnings	// 去掉检测警告
	@Constraint			// 验证器的实现类	


``` java

 Properties prop = new Properties();
        prop.put("mail.transport.protocol", "smtp");// 连接协议
        prop.put("mail.smtp.host", "smtp.exmail.qq.com");// 主机名
        prop.put("mail.smtp.port", 465);// 端口号
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        prop.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到会话对象
        Session session = Session.getInstance(prop);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("service@tech.houtang.net"));
        // 设置收件人邮箱地址
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("1605513752@qq.com"));//一个收件人
        // 设置邮件标题
        message.setSubject("重要文件");
        // 设置邮件内容
        message.setText("Activiti5是由Alfresco软件在2010年5月17日发布的业务流程管理（BPM）框架，它是覆盖了业务流程管理、工作流、服务协作等领域的一个开源的、灵活的、易扩展的可执行流程语言框架。Activiti基于Apache许可的开源BPM平台，创始人Tom Baeyens是JBoss jBPM的项目架构师，它特色是提供了idea插件，开发人员可以通过插件直接绘画出业务");
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("service@tech.houtang.net", "LagjVqEPcWmvQF9c");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
```	
