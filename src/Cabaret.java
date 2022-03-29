import java.util.ArrayList;

public class Cabaret {
    String name = "";
    ArrayList<Performer> performers;

    public Cabaret(String name){
        this.name = name;
        performers = new ArrayList<Performer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Performer> getPerformers() {
        return performers;
    }

    public boolean addPerformer(Performer perf){
        if (!performers.contains(perf)){
            performers.add(perf);
            return true;
        }
        return false;
    }

    public boolean removePerformer(Performer prfmr){
        if(performers.contains(prfmr)){
            performers.remove(performers.indexOf(prfmr));
            return true;
        }
        return false;
    }

    public double averagePerformerAge(){
        double sum = 0.0;
        for (Performer perm: performers){
            sum += perm.getAge();
        }
        return sum/performers.size();
    }

    public ArrayList<Performer> performersOverAge(int age){
        ArrayList<Performer> returnList = new ArrayList<Performer>();
        for (Performer perm: performers) {
            if (perm.getAge() >= age){
                returnList.add(perm);
            }
        }
        return returnList;
    }

    public void groupRehearsal(){
        for (Performer perm: performers) {
            System.out.println("REHEARSAL CALL!" + perm.getName());
            if (perm instanceof Comedian){
                ((Comedian) perm).rehearse(false);
            } else {
                perm.rehearse();
            }
        }
    }

    public void cabaretShow(){
        for (Performer perm: performers) {
            System.out.println("Welcome to the cabaret! Next act up…" + perm.getName());
            if (perm instanceof Dancer){
                ((Dancer) perm).pirouette(2);
                perm.perform();
            } else {
                perm.perform();
            }
        }
    }
}
