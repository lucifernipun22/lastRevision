public class InterviewQuestions {

    /*1. hashmap is basically is data structure in java it works on hashing principle which allow us to store objects there.
    in hashing,hash function are used to link key and value in hashmap. generally we can store objects by using put() method
        we can only store objects not a primitive datatype in hashmap. and we retrieve the store value by using get() method . when we call
    put() method in hashmap then they will called hashcode() method of the key object is called so that the hash function of the map can
            find bucket location.*/

    /*2. static:-  if we use static keyword then we can access only static members and can not access non-static members.
                 static is used compile time binding.
                  static can't be override.
                  if we use static memory location allocation once.

      non-static:- we can access both static and non static members by suing non-static.
                   non- static is used run time binding.
                   non- static can be override .
                   if we use not-static then it occupy more memory space as compare to static.



     */

    /*example of both:-  public class test{
        public static void main(String[] args){
            bird.fly();
            Bird bird = new Bird();
            bird.color();
        }
    }
    class Bird{

        public void color(){
            System.out.println("bird color white");
        }
        public static void fly(){

            System.out.println("bird fly");
        }
    }*/
}
