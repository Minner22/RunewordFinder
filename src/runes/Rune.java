package runes;

import javafx.scene.image.Image;
import util.XMLReader;

import java.io.InputStream;

public enum Rune {

    EL("res/images/r01_El.gif"),
    ELD("res/images/r02_Eld.gif"),
    TIR("res/images/r03_Tir.gif"),
    NEF("res/images/r04_Nef.gif"),
    ETH("res/images/r05_Eth.gif"),
    ITH("res/images/r06_Ith.gif"),
    TAL("res/images/r07_Tal.gif"),
    RAL("res/images/r08_Ral.gif"),
    ORT("res/images/r09_Ort.gif"),
    THUL("res/images/r10_Thul.gif"),
    AMN("res/images/r11_Amn.gif"),
    SOL("res/images/r12_Sol.gif"),
    SHAEL("res/images/r13_Shael.gif"),
    DOL("res/images/r14_Dol.gif"),
    HEL("res/images/r15_Hel.gif"),
    IO("res/images/r16_Io.gif"),
    LUM("res/images/r17_Lum.gif"),
    KO("res/images/r18_Ko.gif"),
    FAL("res/images/r19_Fal.gif"),
    LEM("res/images/r20_Lem.gif"),
    PUL("res/images/r21_Pul.gif"),
    UM("res/images/r22_Um.gif"),
    MAL("res/images/r23_Mal.gif"),
    IST("res/images/r24_Ist.gif"),
    GUL("res/images/r25_Gul.gif"),
    VEX("res/images/r26_Vex.gif"),
    OHM("res/images/r27_Ohm.gif"),
    LO("res/images/r28_Lo.gif"),
    SUR("res/images/r29_Sur.gif"),
    BER("res/images/r30_Ber.gif"),
    JAH("res/images/r31_Jah.gif"),
    CHAM("res/images/r32_Cham.gif"),
    ZOD("res/images/r33_Zod.gif");

    //private final String imgDir;
    private final Image image;
    private final String properties;

    Rune(String imgDir) {
        //this.imgDir = imgDir;
        Image tempImage;
        String tempProp = "";
        //XMLReader xmlReader = new XMLReader();
        try {
            InputStream in = getClass().getClassLoader().getResourceAsStream(imgDir);
            assert in != null;
            tempImage = new Image(in);

            XMLReader xmlReader = new XMLReader();
            tempProp = xmlReader.getXMLRuneProp(this);

        } catch (Exception e) {
            e.printStackTrace();
            tempImage = null;
        }
        image = tempImage;
        properties = tempProp;
    }

    /*
    public String getImgDir() {
        return imgDir;
    }
     */

    public Image getImage() {
        return image;
    }


    public String getProperties() {
        return properties;
    }
}

