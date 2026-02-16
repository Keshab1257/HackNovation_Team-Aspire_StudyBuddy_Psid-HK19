class UnderAgeException extends RuntimeException{
    UnderAgeException(String str){
        super(str);
    }
}

class Exception2{
    public static void main (String[] args) {
        try{
            if(5<18){
                throw new UnderAgeException("age is not valid");
            }else{
                System.out.println("YOur dbchbs");
            }
        }
        catch(UnderAgeException e){
            System.out.println(e);
        }
    }
}


