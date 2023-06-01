class Admin{
    public void print()throws Exception{
        Adminmodel model=new Adminmodel();
        Adminview view=new Adminview();
        Admincontroller controller=new Admincontroller(model,view);
        controller.process();
    }
}