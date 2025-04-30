package org.confluence.delight.common.registry;

import net.minecraft.core.Holder;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvent;

import static org.confluence.delight.ConfluenceDelight.resource;

public class ModSounds {
    public static final Music TITLE_INTRO = new Music(Holder.direct(
            SoundEvent.createVariableRangeEvent(
                    resource("music.title.intro")
            )), 0, 0, true);

    public static final Music TITLE = new Music(Holder.direct(
            SoundEvent.createVariableRangeEvent(
                    resource("music.title")
            )), 0, 0, false);
    public static final SoundEvent ADVANCEMENT_TOAST_OUT = SoundEvent.createVariableRangeEvent(
            resource("ui.advancement_toast.out")
    );
    public static final SoundEvent BLOCK_CUTTING_BOARD_HOT_KNIFE = SoundEvent.createVariableRangeEvent(
            resource("block.cutting_board.knife.hot")
    );
}
