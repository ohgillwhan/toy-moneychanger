image_name=mysql_gillwhan

docker stop $image_name
docker rm $image_name

docker run -d -p 33060:3306 -e MYSQL_ROOT_PASSWORD=qwer1234 --name $image_name mysql < db.sql
docker cp ./db.sql $image_name:/docker-entrypoint-initdb.d/db.sql