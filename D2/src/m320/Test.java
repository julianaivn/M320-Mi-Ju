package m320;

public class Test {
    private float achivedPoints;
    private int maxPoints;

    public Test(float achivedPoints, int maxPoints) {
        this.achivedPoints = achivedPoints;
        this.maxPoints = maxPoints;
    }

    public float calculateGrade(){
        return  achivedPoints * 5 / maxPoints + 1;
    }
    public float getAchivedPoints() {
        return achivedPoints;
    }

    public void setAchivedPoints(float achivedPoints) {
        this.achivedPoints = achivedPoints;
    }

    public float getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }
}
