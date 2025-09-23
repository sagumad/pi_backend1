$javaProps = & java -XshowSettings:properties -version 2>&1 | Select-String "java.home"
$path = $javaProps -replace '.*=\s*',''
if ($path) { $env:JAVA_HOME=$path }
./mvnw -DskipTests spring-boot:run
