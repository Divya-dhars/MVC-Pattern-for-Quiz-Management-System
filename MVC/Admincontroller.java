class Admincontroller {
    private Adminmodel model;
    private Adminview view;
    public Admincontroller(Adminmodel model, Adminview view) {
        this.model = model;
        this.view = view;
    }
    public void process() throws Exception {
        int i=0;
        do{
            System.out.println("1.To add new Questions || 2.To Delete Questions || 3.To Update Questions || 4.To Display Questions");
            i=view.input();
            switch(i){
                case 1:
                    System.out.println("Enter Question No:");
                    int no=view.qno();
                    System.out.println("Enter Question:");
                    String question = view.question();
                    System.out.println("Enter Answer:");
                    String answer = view.answer();
                    model.insert(no,question,answer);
                    break;
                case 2:
                    System.out.println("Enter Question No:");
                    no=view.qno();
                    model.delete(no);
                    break;
                case 3:
                    do{
                        System.out.println("1.To Update Question No || 2.To Update Question || 3.To Update Question Answer || 4.To Display Available Questions");
                        i=view.input();
                        switch(i){
                            case 1:
                                System.out.println("Enter Question No:");
                                no=view.qno();
                                System.out.println("Enter new Question No:");
                                int newqno=view.qno();
                                model.updateId(no, newqno);
                                break;
                            case 2:
                                System.out.println("Enter Question:");
                                question=view.question();
                                System.out.println("Enter New Question:");
                                String newquestion=view.question();
                                model.updateQuestion(question, newquestion);
                                break;
                            case 3:
                                System.out.println("Enter Answer:");
                                answer=view.answer();
                                System.out.println("Enter new Answer:");
                                String newanswer=view.answer();
                                model.updateAnswer(answer,newanswer);
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
                    break;
                case 4:
                    view.display();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Options");
                    break;
            }
        }
        while(i!=5);
    }
}
