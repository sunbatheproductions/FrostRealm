package baguchan.frostrealm.entity.goal;

import baguchan.frostrealm.entity.IHasEgg;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.animal.Animal;

import java.util.EnumSet;

public abstract class FindAndPlaceEggGoal<T extends Animal & IHasEgg> extends MoveToBlockGoal {
    private final T animal;

    public FindAndPlaceEggGoal(T animal, double speed) {
        super(animal, speed, 8);
        this.animal = animal;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean canUse() {
        return super.canUse() && this.animal.hasEgg();
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.animal.isAlive() && this.animal.hasEgg()) {
            BlockPos blockpos = this.animal.blockPosition();
            if (this.isReachedTarget()) {
                afterPlaceEgg();
                this.animal.setHasEgg(false);
                this.animal.setAge(2400);
            }
        }
    }

    public abstract void afterPlaceEgg();

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }
}