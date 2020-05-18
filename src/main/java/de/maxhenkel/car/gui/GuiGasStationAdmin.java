package de.maxhenkel.car.gui;

import de.maxhenkel.car.Main;
import de.maxhenkel.car.blocks.tileentity.TileEntityGasStation;
import de.maxhenkel.car.net.MessageGasStationAdminAmount;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import java.awt.*;

public class GuiGasStationAdmin extends GuiBase<ContainerGasStationAdmin> {

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(Main.MODID, "textures/gui/gui_gas_station_admin.png");

    private TileEntityGasStation gasStation;
    private PlayerInventory inventoryPlayer;

    private static final int TITLE_COLOR = Color.WHITE.getRGB();
    private static final int FONT_COLOR = Color.DARK_GRAY.getRGB();

    protected TextFieldWidget textField;

    public GuiGasStationAdmin(ContainerGasStationAdmin gasStation, PlayerInventory playerInventory, ITextComponent title) {
        super(GUI_TEXTURE, gasStation, playerInventory, title);
        this.gasStation = gasStation.getGasStation();
        this.inventoryPlayer = playerInventory;

        xSize = 176;
        ySize = 197;
    }

    @Override
    protected void init() {
        super.init();

        minecraft.keyboardListener.enableRepeatEvents(true);
        textField = new TextFieldWidget(font, guiLeft + 54, guiTop + 22, 100, 16, new TranslationTextComponent("gas_station.admin.amount_text_field").getFormattedText());
        textField.setCanLoseFocus(false);
        textField.changeFocus(true);
        textField.setTextColor(-1);
        textField.setDisabledTextColour(-1);
        textField.setMaxStringLength(20);
        textField.setText(String.valueOf(gasStation.getTradeAmount()));
        textField.setResponder(this::onTextChanged);
        children.add(textField);
        setFocused(textField);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        super.render(mouseX, mouseY, partialTicks);
        textField.render(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }

    public void onTextChanged(String text) {
        if (textField.isFocused()) {
            if (!text.isEmpty()) {
                try {
                    int i = Integer.parseInt(text);
                    Main.SIMPLE_CHANNEL.sendToServer(new MessageGasStationAdminAmount(gasStation.getPos(), i));
                } catch (Exception e) {
                }
            }
        }
    }

    @Override
    public void removed() {
        super.removed();
        minecraft.keyboardListener.enableRepeatEvents(false);
    }

    @Override
    public void resize(Minecraft mc, int x, int y) {
        String text = textField.getText();
        init(mc, x, y);
        textField.setText(text);
    }

    @Override
    public boolean keyPressed(int key, int a, int b) {
        if (key == 256) {
            this.minecraft.player.closeScreen();
        }

        return !textField.keyPressed(key, a, b) && !textField.canWrite() ? super.keyPressed(key, a, b) : true;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        super.drawGuiContainerForegroundLayer(x, y);

        drawCenteredString(font, new TranslationTextComponent("gui.gas_station").getFormattedText(),
                xSize / 2, 5, TITLE_COLOR);

        font.drawString(inventoryPlayer.getDisplayName().getFormattedText(), 8, ySize - 93, FONT_COLOR);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}