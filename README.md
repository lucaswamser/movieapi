# Movies API


## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

```shell
mvn spring-boot:run
```

## Running the application test locally

```shell
mvn test
```

# Calling API

## Get the producer winner interval

```shell
curl http://localhost:8080/movies/winnerinterval
```

```json
{
    "min": [
        {
            "followingWin": 1991,
            "previousWin": 1990,
            "interval": 1,
            "producer": "Joel Silver"
        },
        {
            "followingWin": 1990,
            "producer": "Bo Derek",
            "interval": 6,
            "previousWin": 1984
        }
    ],
    "max": [
        {
            "producer": "Matthew Vaughn",
            "interval": 13,
            "followingWin": 2015,
            "previousWin": 2002
        },
        {
            "interval": 9,
            "producer": "Buzz Feitshans",
            "followingWin": 1994,
            "previousWin": 1985
        }
    ]
}
...
```

## Get movies list

```shell
curl http://localhost:8080/movies/list
```
```json
[
    {
        "year": 1980,
        "title": "Can't Stop the Music",
        "studios": "Associated Film Distribution",
        "producers": [
            "Allan Carr"
        ],
        "winner": true
    },
    {
        "year": 1980,
        "title": "Cruising",
        "studios": "Lorimar Productions, United Artists",
        "producers": [
            "Jerry Weintraub"
        ],
        "winner": false
    },
    {...}
   
]
```