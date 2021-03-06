package edu.fmi.genderclassify.weka.features;

import edu.fmi.genderclassify.dataimport.Fields;
import edu.fmi.genderclassify.utils.Conversion;
import weka.core.Attribute;

import java.util.*;

/**
 * A factory for creating Attribute instances for the input (base) features
 */
@SuppressWarnings("unused")
public class BaseFeaturesFactory {
    private Map<String, Set<Object>> dataDomain;

    public BaseFeaturesFactory(Map<String, Set<Object>> dataDomain) {
        this.dataDomain = dataDomain;
    }

    public Attribute getUserId() {
        return getNumericAttribute(Fields.USER_ID);
    }

    public Attribute getGolden() {
        return getNominalAttribute(Fields.GOLDEN);
    }

    public Attribute getUnitState() {
        return getNominalAttribute(Fields.UNIT_STATE);
    }

    public Attribute getTrustedJudgements() {
        return getNumericAttribute(Fields.TRUSTED_JUDGEMENTS);
    }

    public Attribute getLastJudgementTime() {
        return getStringAttribute(Fields.LAST_JUDGEMENT_TIME);
    }

    public Attribute getGender() {
        return getNominalAttribute(Fields.GENDER);
    }

    public Attribute getGenderConfidence() {
        return getNumericAttribute(Fields.GENDER_CONFIDENCE);
    }

    public Attribute getProfileExists() {
        return getNominalAttribute(Fields.PROFILE_EXISTS);
    }

    public Attribute getProfileExistsConfidence() {
        return getNumericAttribute(Fields.PROFILE_EXISTS_CONFIDENCE);
    }

    public Attribute getProfileCreationDate() {
        return getStringAttribute(Fields.PROFILE_CREATION_DATE);
    }

    public Attribute getDescription() {
        return getStringAttribute(Fields.PROFILE_DESCRIPTION);
    }

    public Attribute getFavoritesNumber() {
        return getNumericAttribute(Fields.FAVORITES_NUMBER);
    }

    public Attribute getGenderGold() {
        return getNominalAttribute(Fields.GENDER_GOLDEN);
    }

    public Attribute getLinkColor() {
        return getNominalColorAttribute(Fields.LINK_COLOR);
    }

    public Attribute getUserName() {
        return getStringAttribute(Fields.USERNAME);
    }

    public Attribute getProfileYnGolden() {
        return getNominalAttribute(Fields.PROFILE_YN_VALUE_GOLDEN);
    }

    public Attribute getProfileImageLink() {
        return getStringAttribute(Fields.PROFILE_IMAGE_LINK);
    }

    public Attribute getRetweetsCount() {
        return getNumericAttribute(Fields.RETWEET_COUNT);
    }

    public Attribute getSidebarColor() {
        return getNominalColorAttribute(Fields.SIDEBAR_COLOR);
    }

    public Attribute getText() {
        return getStringAttribute(Fields.TWEET_TEXT);
    }

    public Attribute getTweetsCount() {
        return getNumericAttribute(Fields.TWEETS_COUNT);
    }

    public Attribute getTweetCreationDate() {
        return getStringAttribute(Fields.TWEET_CREATION_DATE);
    }

    public Attribute getTweetId() {
        return getStringAttribute(Fields.TWEET_ID);
    }

    public Attribute getTweetLocation() {
        return getStringAttribute(Fields.TWEET_LOCATION);
    }

    public Attribute getUserTimezone() {
        return getStringAttribute(Fields.USER_TIMEZONE);
    }

    private Attribute getNominalAttribute(Fields field) {
        Set<String> values = new HashSet<>();
        for(Object obj: dataDomain.get(field.name()))
            values.add(Conversion.getValueAsStr(obj));

        return new Attribute(field.name(), new ArrayList<>(values));
    }

    private Attribute getNominalColorAttribute(Fields field) {
        Set<String> values = new HashSet<>();
        for(Object obj: dataDomain.get(field.name()))
            values.add(Conversion.getHexColorAsNominal(obj.toString()));

        return new Attribute(field.name(), new ArrayList<>(values));
    }

    private Attribute getNumericAttribute(Fields field) {
        return new Attribute(field.name());
    }

    private Attribute getStringAttribute(Fields field) {
        return new Attribute(field.name(), true);
    }
}
