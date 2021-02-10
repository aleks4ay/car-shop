<#import "/spring.ftl" as spring/>

<html lang="en">
<head>
    <title>Person List</title>
    <link rel="stylesheet"
          type="text/css"
          href="<@spring.url '/css/style.css'/>"/>
</head>
<body>
<h3>List Hello</h3>
<br><br>
<div>
    Hello from ${name}</td>
    <p><a href="newClient">New user</a></p>
    <p><a href="clients">List user</a></p>
</div>
</body>
</html>