package topic11.practice;

sealed interface Result permits Success, Failure {

}

record Success(String email) implements Result {}
record Failure(String email) implements Result {}
