case $1 in
  "build")
    echo "creating build container"

    docker build . -t microbank

    docker run -v $(pwd):/home/build/ microbank

    docker rmi microbank --force

    echo "built"

 ;;

  "run")
    docker compose -p "microbank" up -d --force-recreate --build
  ;;

  "buildrun")

    echo "creating build container"

    docker build . -t microbank

    docker run -v $(pwd):/home/build/ microbank

    docker rmi microbank --force

    echo "built"

    echo "running"

    docker compose -p "microbank" up -d --force-recreate --build
  ;;
esac
