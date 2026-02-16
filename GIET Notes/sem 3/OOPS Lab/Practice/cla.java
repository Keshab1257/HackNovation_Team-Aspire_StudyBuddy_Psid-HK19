class cla{
    public static void main(String args[]){
        if(args.length > 0){
            for(String arg : args){
                System.out.print(arg + " ");
            }
        }else{
            System.out.print("No Values.");
        }
        System.out.println(args.length);
    }
}