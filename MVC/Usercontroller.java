class Usercontroller {
    private Usermodel model;
    private Userview view;
    public Usercontroller(Usermodel model, Userview view){
        this.model=model;
        this.view=view;
    }
    public void process() throws Exception {
        int i=0;
        do{
            System.out.println("1.To Answer || 2.To Delete Answer ||3.To Update Answer ||4.To Display Answer");
            i=view.input();
            switch(i){
                case 1:
                    System.out.println("Enter Question No:");
                    int no=view.qno();
                    System.out.println("Enter Answer:");
                    String answer=view.answer();
                    model.insert(no, answer);
                    break;
                case 2:
                    System.out.println("Enter Question No:");
                    no=view.qno();
                    model.delete(no);
                    break;
                case 3:
                    System.out.println("Enter Question No:");
                    no=view.qno();
                    System.out.println("Enter Answer:");
                    answer=view.answer();
                    System.out.println("Enter new Answer:");
                    String newAnswer=view.answer();
                    model.update(no, answer, newAnswer);
                    break;
                case 4:
                    view.display();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
        while(i!=5);
    }
}