class User{
    public void print()throws Exception{
    Usermodel model=new Usermodel();
    Userview view=new Userview();
    Usercontroller controller=new Usercontroller(model,view);
    controller.process();
    }
}