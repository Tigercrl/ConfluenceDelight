package org.confluence.delight.data.gen;

import net.minecraft.data.PackOutput;
import net.minecraft.sounds.Music;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import org.confluence.delight.ConfluenceDelight;
import org.confluence.delight.common.registry.ModSounds;

import static org.confluence.delight.ConfluenceDelight.resource;

public class ModSoundDefinitionsProvider extends SoundDefinitionsProvider {
    public ModSoundDefinitionsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ConfluenceDelight.MODID, existingFileHelper);
    }

    @Override
    public void registerSounds() {
        addMusic(ModSounds.TITLE_INTRO, definition().with(
                sound(resource("music/title_intro")).stream().volume(0.5)
        ));
        addMusic(ModSounds.TITLE, definition().with(
                sound(resource("music/title")).stream().volume(0.5)
        ));
        add(ModSounds.ADVANCEMENT_TOAST_OUT, definition().with(
                sound(resource("sound/achievement_complete"))
        ));
        add(ModSounds.BLOCK_CUTTING_BOARD_HOT_KNIFE, definition().with(
                sound("random/fizz")
        ).subtitle("confluence_delight.subtitles.cutting_board.knife_cut.hot"));
    }

    private void addMusic(Music music, SoundDefinition definition) {
        add(music.getEvent().value().getLocation(), definition);
    }

}