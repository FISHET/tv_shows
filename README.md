# TV Series Lookup

Orders TV Series for a given genre based on IMDB reviews and spits out the top result 

## How to build

```shell
  ./gradlew build 
```

## How to run

```shell
 ./gradlew run --args=<your_genre>
```

e.g.

```shell
 ./gradlew run --args=Action
```

should return

```shell
The highest rated Action series is: "Game of Thrones"
```