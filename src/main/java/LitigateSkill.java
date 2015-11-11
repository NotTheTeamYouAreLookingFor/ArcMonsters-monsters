/**
 * Created by alexandernohe on 11/10/15.
 */
public class LitigateSkill extends Skills {

    public LitigateSkill(String Name, int MaxNRG, int Cooldown, int CostPerAttach)
    {
        super(Name, MaxNRG, Cooldown, CostPerAttach);
    }

    @Override
    public void Action(Worker attackingWorker, Worker defendingWorker) {
        if (this.currentNRG == 0)
        {
            //Maybe we could throw a custom exception here
        }
        else {
            int differenceInLevel = attackingWorker.getLevel() - defendingWorker.getLevel();
            double damage;
            if (differenceInLevel < 0) {
                damage = .5;
            } else if (differenceInLevel == 0) {
                damage = 1;
            } else {
                damage = differenceInLevel;
            }
            defendingWorker.adjustHP(-(int) (damage * 2));
            this.adjustNRG();
        }
    }
}
