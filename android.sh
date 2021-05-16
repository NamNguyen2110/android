git status
git add .
now=$(date +"%c")
git commit -m "update project at $now"
git push
echo "Pushed to GitHub repository"
echo "------------------------------------------------------"
rm -r target
echo "Deleted target folder"
echo "------------------------------------------------------"
docker image rm -f namnguyen2110/android:latest
mvn install DskipTest=true
docker build -t namnguyen2110/android:latest .
echo "Build completed docker image: namnguyen2110/android:latest"
echo "-------------------------------------------------------"
docker run --name android -d -p=8080:8080 namnguyen2110/android > service.log 2>&1 &
docker commit android namnguyen2110/android:latest
docker push namnguyen2110/android:latest
echo "Pushed to Dockerhub repository"
echo "--------------------------------------------------------"
docker stop android
docker rm android
echo "Stop and remove the completed current container"
echo "---------------------------------------------------------"
echo "Completed automation deployment on local"