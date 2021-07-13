object PrintName {                                                 //1
    fun Name(name: String, age: String) {        //2
        println("Name is $name")
        println("Age of $name is $age")
    }
}

fun main(){
    PrintName.Name("nipun", "18")                          //3
}