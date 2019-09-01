package com.example.alaa.custom_views;

import android.content.Context;
import android.graphics.Typeface;

class FontFace {
    private static final FontFace ourInstance = new FontFace();

    private String[] fontFace = new String[]{
            "Font/IRANSansMobile_Light.ttf",
            "Font/IRANSansMobile_Medium.ttf",
            "Font/IRANSansMobile_Bold.ttf",
            "Font/IRANSansMobile_UltraLight.ttf",
            "Font/IRANSansMobile_Light-4.1.ttf",
            "Font/BSara.ttf",
            "Font/shabnam_light.ttf",
            "Font/estedad.ttf",
            "Font/Suls.ttf",
            "Font/Shekasteh.ttf",
            "Font/IRANSansMobile(FaNum).ttf",
            "Font/IRANSansMobile(FaNum)_Bold.ttf",
            "Font/IRANSansMobile(FaNum)_Light.ttf",
            "Font/IRANSansMobile(FaNum)_Medium.ttf",
            "Font/IRANSansMobile(FaNum)_UltraLight.ttf",
            "Font/Mali_BoldItalic.ttf",
            "Font/RubikMonoOne_Regular.ttf",
            "Font/Dima.ttf"
    };

    private FontFace() {
    }

    static FontFace getInstance() {
        return ourInstance;
    }

    String[] getFontsArray() {
        return fontFace;
    }

    private String getFontStringPathFromAsset(int fontOrdinal) {
        return fontFace[handleFontOrdinalOutOfIndex(fontOrdinal)];
    }

    private int handleFontOrdinalOutOfIndex(int fontOrdinal) {
        return ((fontOrdinal - 1) >= 0 && fontOrdinal <= fontFace.length) ? fontOrdinal - 1 : 0;
    }

    Typeface getFontFace(Context context, int fontOrdinal) {
        return Typeface.createFromAsset(context.getAssets(), getFontStringPathFromAsset(fontOrdinal));
    }
}
