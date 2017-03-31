package com.commercetools.sync.categories;

import com.commercetools.sync.services.TypeService;
import io.sphere.sdk.categories.Category;
import io.sphere.sdk.categories.CategoryDraft;
import io.sphere.sdk.commands.UpdateAction;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.commercetools.sync.commons.CustomDiff.buildCustomActions;
import static com.commercetools.sync.categories.CategoryUpdateActionUtils.*;

public class CategorySyncUtils {

    /**
     * TODO: JAVADOC.
     * TODO: UNIT TEST.
     * TODO: NEEDS TO BE IMPLEMENTED. GITHUB ISSUE#9
     *
     * @param oldCategory
     * @param newCategory
     * @param typeService
     * @return
     */
    @Nonnull
    public static List<UpdateAction<Category>> buildActions(@Nonnull final Category oldCategory,
                                                            @Nonnull final Category newCategory,
                                                            @Nonnull final TypeService typeService) {
        final List<UpdateAction<Category>> updateActions = buildCoreActions(oldCategory, newCategory, typeService);
        final List<UpdateAction<Category>> assetUpdateActions = buildAssetActions(oldCategory, newCategory);
        return Stream.concat(updateActions.stream(),
                assetUpdateActions.stream())
                .collect(Collectors.toList());
    }

    /**
     * TODO: NEEDS TO BE IMPLEMENTED. GITHUB ISSUE#9
     * SHOULD TRANSFORM Category TO CategoryDraft
     * then call {@link CategorySyncUtils#buildCoreActions(Category, CategoryDraft, TypeService)}.
     *
     * @param oldCategory
     * @param newCategory
     * @param typeService
     * @return
     */
    @Nonnull
    public static List<UpdateAction<Category>> buildCoreActions(@Nonnull final Category oldCategory,
                                                                @Nonnull final Category newCategory,
                                                                @Nonnull final TypeService typeService) {
        return new ArrayList<>();
    }

    /**
     * TODO: NEEDS TO BE IMPLEMENTED. GITHUB ISSUE#9
     * SHOULD TRANSFORM Category TO CategoryDraft
     * then call {@link CategorySyncUtils#buildAssetActions(Category, CategoryDraft)}.
     *
     * @param oldCategory
     * @param newCategory
     * @return
     */
    @Nonnull
    public static List<UpdateAction<Category>> buildAssetActions(@Nonnull final Category oldCategory,
                                                                 @Nonnull final Category newCategory) {
        return new ArrayList<>();
    }

    /**
     * TODO: JAVADOC
     * TODO: UNIT TEST
     *
     * @param oldCategory
     * @param newCategory
     * @param typeService
     * @return
     */
    @Nonnull
    public static List<UpdateAction<Category>> buildActions(@Nonnull final Category oldCategory,
                                                            @Nonnull final CategoryDraft newCategory,
                                                            @Nonnull final TypeService typeService) {
        final List<UpdateAction<Category>> updateActions = buildCoreActions(oldCategory, newCategory, typeService);
        final List<UpdateAction<Category>> assetUpdateActions = buildAssetActions(oldCategory, newCategory);
        return Stream.concat(updateActions.stream(),
                assetUpdateActions.stream())
                .collect(Collectors.toList());
    }

    /**
     * TODO: JAVADOC
     * TODO: UNIT TEST
     *
     * @param oldCategory
     * @param newCategory
     * @param typeService
     * @return
     */
    @Nonnull
    public static List<UpdateAction<Category>> buildCoreActions(@Nonnull final Category oldCategory,
                                                                @Nonnull final CategoryDraft newCategory,
                                                                @Nonnull final TypeService typeService) {
        final List<UpdateAction<Category>> updateActions = new ArrayList<>();
        buildChangeNameUpdateAction(oldCategory, newCategory)
                .map(updateActions::add);

        buildChangeSlugUpdateAction(oldCategory, newCategory)
                .map(updateActions::add);

        buildSetDescriptionUpdateAction(oldCategory, newCategory)
                .map(updateActions::add);

        buildChangeParentUpdateAction(oldCategory, newCategory)
                .map(updateActions::add);

        buildChangeOrderHintUpdateAction(oldCategory, newCategory)
                .map(updateActions::add);

        buildSetMetaTitleUpdateAction(oldCategory, newCategory)
                .map(updateActions::add);

        buildSetMetaDescriptionUpdateAction(oldCategory, newCategory)
                .map(updateActions::add);

        buildSetMetaKeywordsUpdateAction(oldCategory, newCategory)
                .map(updateActions::add);

        final List<UpdateAction<Category>> categoryTypeUpdateActions =
                buildCustomActions(oldCategory, newCategory, typeService);
        return Stream.concat(updateActions.stream(),
                categoryTypeUpdateActions.stream())
                .collect(Collectors.toList());
    }


    /**
     * - addAsset
     * - removeAsset
     * - changeAssetOrder
     * - changeAssetName
     * - setAssetDescription
     * - setAssetTags
     * - setAssetSources
     * - setAssetCustomType
     * - setAssetCustomField
     *
     * @param oldCategory
     * @param newCategory
     * @return
     */
    @Nonnull
    public static List<UpdateAction<Category>> buildAssetActions(@Nonnull final Category oldCategory,
                                                                 @Nonnull final CategoryDraft newCategory) {
        return new ArrayList<>();
    }
}
