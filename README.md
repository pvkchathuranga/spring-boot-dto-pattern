# spring-boot-dto-pattern

✔ How to use spring-boot with design layers and patterns 

1️⃣ You need to change 'application.property' file with your MySQL username and password

    spring.datasource.username=root 
    spring.datasource.password=root

2️⃣ Also, below line need to match with your database name (replace 'test' with your db name)

    spring.datasource.url=jdbc:mysql://localhost:3306/test?createDatabaseIfNotExist=true
    
3️⃣ Change 13,14,15,16 and 19 lines in application.property file according to your mail server, username and password etc.

📌 You can access 19 line at your logic layer
    
    @Value("${sender.email}")
	private String senderMail;

    
  
![Screenshot 2023-04-12 000422](https://user-images.githubusercontent.com/39025222/231258113-325c1e2e-599e-4a02-a98f-3a201deb85ab.png)

