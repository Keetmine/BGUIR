package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_ivanov_accounting_realm_productRealmProxy extends com.ivanov.accounting.realm.product
    implements RealmObjectProxy, com_ivanov_accounting_realm_productRealmProxyInterface {

    static final class productColumnInfo extends ColumnInfo {
        long idIndex;
        long nameIndex;
        long descriptionIndex;
        long companyIndex;
        long groupIndex;

        productColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("product");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.descriptionIndex = addColumnDetails("description", "description", objectSchemaInfo);
            this.companyIndex = addColumnDetails("company", "company", objectSchemaInfo);
            this.groupIndex = addColumnDetails("group", "group", objectSchemaInfo);
        }

        productColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new productColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final productColumnInfo src = (productColumnInfo) rawSrc;
            final productColumnInfo dst = (productColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.nameIndex = src.nameIndex;
            dst.descriptionIndex = src.descriptionIndex;
            dst.companyIndex = src.companyIndex;
            dst.groupIndex = src.groupIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private productColumnInfo columnInfo;
    private ProxyState<com.ivanov.accounting.realm.product> proxyState;

    com_ivanov_accounting_realm_productRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (productColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.ivanov.accounting.realm.product>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descriptionIndex);
    }

    @Override
    public void realmSet$description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descriptionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descriptionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descriptionIndex, value);
    }

    @Override
    public com.ivanov.accounting.realm.company realmGet$company() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.companyIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.ivanov.accounting.realm.company.class, proxyState.getRow$realm().getLink(columnInfo.companyIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$company(com.ivanov.accounting.realm.company value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("company")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.companyIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.companyIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.companyIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.companyIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.ivanov.accounting.realm.group realmGet$group() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.groupIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.ivanov.accounting.realm.group.class, proxyState.getRow$realm().getLink(columnInfo.groupIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$group(com.ivanov.accounting.realm.group value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("group")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.groupIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.groupIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.groupIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.groupIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("product", 5, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("company", RealmFieldType.OBJECT, "company");
        builder.addPersistedLinkProperty("group", RealmFieldType.OBJECT, "group");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static productColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new productColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "product";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "product";
    }

    @SuppressWarnings("cast")
    public static com.ivanov.accounting.realm.product createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        com.ivanov.accounting.realm.product obj = null;
        if (update) {
            Table table = realm.getTable(com.ivanov.accounting.realm.product.class);
            productColumnInfo columnInfo = (productColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.product.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.product.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_ivanov_accounting_realm_productRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("company")) {
                excludeFields.add("company");
            }
            if (json.has("group")) {
                excludeFields.add("group");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_ivanov_accounting_realm_productRealmProxy) realm.createObjectInternal(com.ivanov.accounting.realm.product.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_ivanov_accounting_realm_productRealmProxy) realm.createObjectInternal(com.ivanov.accounting.realm.product.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_ivanov_accounting_realm_productRealmProxyInterface objProxy = (com_ivanov_accounting_realm_productRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                objProxy.realmSet$description(null);
            } else {
                objProxy.realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("company")) {
            if (json.isNull("company")) {
                objProxy.realmSet$company(null);
            } else {
                com.ivanov.accounting.realm.company companyObj = com_ivanov_accounting_realm_companyRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("company"), update);
                objProxy.realmSet$company(companyObj);
            }
        }
        if (json.has("group")) {
            if (json.isNull("group")) {
                objProxy.realmSet$group(null);
            } else {
                com.ivanov.accounting.realm.group groupObj = com_ivanov_accounting_realm_groupRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("group"), update);
                objProxy.realmSet$group(groupObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.ivanov.accounting.realm.product createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.ivanov.accounting.realm.product obj = new com.ivanov.accounting.realm.product();
        final com_ivanov_accounting_realm_productRealmProxyInterface objProxy = (com_ivanov_accounting_realm_productRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$description(null);
                }
            } else if (name.equals("company")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$company(null);
                } else {
                    com.ivanov.accounting.realm.company companyObj = com_ivanov_accounting_realm_companyRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$company(companyObj);
                }
            } else if (name.equals("group")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$group(null);
                } else {
                    com.ivanov.accounting.realm.group groupObj = com_ivanov_accounting_realm_groupRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$group(groupObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.ivanov.accounting.realm.product copyOrUpdate(Realm realm, com.ivanov.accounting.realm.product object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.ivanov.accounting.realm.product) cachedRealmObject;
        }

        com.ivanov.accounting.realm.product realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.ivanov.accounting.realm.product.class);
            productColumnInfo columnInfo = (productColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.product.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.product.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_ivanov_accounting_realm_productRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.ivanov.accounting.realm.product copy(Realm realm, com.ivanov.accounting.realm.product newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.ivanov.accounting.realm.product) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.ivanov.accounting.realm.product realmObject = realm.createObjectInternal(com.ivanov.accounting.realm.product.class, ((com_ivanov_accounting_realm_productRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_ivanov_accounting_realm_productRealmProxyInterface realmObjectSource = (com_ivanov_accounting_realm_productRealmProxyInterface) newObject;
        com_ivanov_accounting_realm_productRealmProxyInterface realmObjectCopy = (com_ivanov_accounting_realm_productRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$description(realmObjectSource.realmGet$description());

        com.ivanov.accounting.realm.company companyObj = realmObjectSource.realmGet$company();
        if (companyObj == null) {
            realmObjectCopy.realmSet$company(null);
        } else {
            com.ivanov.accounting.realm.company cachecompany = (com.ivanov.accounting.realm.company) cache.get(companyObj);
            if (cachecompany != null) {
                realmObjectCopy.realmSet$company(cachecompany);
            } else {
                realmObjectCopy.realmSet$company(com_ivanov_accounting_realm_companyRealmProxy.copyOrUpdate(realm, companyObj, update, cache));
            }
        }

        com.ivanov.accounting.realm.group groupObj = realmObjectSource.realmGet$group();
        if (groupObj == null) {
            realmObjectCopy.realmSet$group(null);
        } else {
            com.ivanov.accounting.realm.group cachegroup = (com.ivanov.accounting.realm.group) cache.get(groupObj);
            if (cachegroup != null) {
                realmObjectCopy.realmSet$group(cachegroup);
            } else {
                realmObjectCopy.realmSet$group(com_ivanov_accounting_realm_groupRealmProxy.copyOrUpdate(realm, groupObj, update, cache));
            }
        }
        return realmObject;
    }

    public static long insert(Realm realm, com.ivanov.accounting.realm.product object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.ivanov.accounting.realm.product.class);
        long tableNativePtr = table.getNativePtr();
        productColumnInfo columnInfo = (productColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.product.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$description = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }

        com.ivanov.accounting.realm.company companyObj = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$company();
        if (companyObj != null) {
            Long cachecompany = cache.get(companyObj);
            if (cachecompany == null) {
                cachecompany = com_ivanov_accounting_realm_companyRealmProxy.insert(realm, companyObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.companyIndex, rowIndex, cachecompany, false);
        }

        com.ivanov.accounting.realm.group groupObj = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$group();
        if (groupObj != null) {
            Long cachegroup = cache.get(groupObj);
            if (cachegroup == null) {
                cachegroup = com_ivanov_accounting_realm_groupRealmProxy.insert(realm, groupObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.groupIndex, rowIndex, cachegroup, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.ivanov.accounting.realm.product.class);
        long tableNativePtr = table.getNativePtr();
        productColumnInfo columnInfo = (productColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.product.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.ivanov.accounting.realm.product object = null;
        while (objects.hasNext()) {
            object = (com.ivanov.accounting.realm.product) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$name = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$description = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            }

            com.ivanov.accounting.realm.company companyObj = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$company();
            if (companyObj != null) {
                Long cachecompany = cache.get(companyObj);
                if (cachecompany == null) {
                    cachecompany = com_ivanov_accounting_realm_companyRealmProxy.insert(realm, companyObj, cache);
                }
                table.setLink(columnInfo.companyIndex, rowIndex, cachecompany, false);
            }

            com.ivanov.accounting.realm.group groupObj = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$group();
            if (groupObj != null) {
                Long cachegroup = cache.get(groupObj);
                if (cachegroup == null) {
                    cachegroup = com_ivanov_accounting_realm_groupRealmProxy.insert(realm, groupObj, cache);
                }
                table.setLink(columnInfo.groupIndex, rowIndex, cachegroup, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.ivanov.accounting.realm.product object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.ivanov.accounting.realm.product.class);
        long tableNativePtr = table.getNativePtr();
        productColumnInfo columnInfo = (productColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.product.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$description = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }

        com.ivanov.accounting.realm.company companyObj = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$company();
        if (companyObj != null) {
            Long cachecompany = cache.get(companyObj);
            if (cachecompany == null) {
                cachecompany = com_ivanov_accounting_realm_companyRealmProxy.insertOrUpdate(realm, companyObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.companyIndex, rowIndex, cachecompany, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.companyIndex, rowIndex);
        }

        com.ivanov.accounting.realm.group groupObj = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$group();
        if (groupObj != null) {
            Long cachegroup = cache.get(groupObj);
            if (cachegroup == null) {
                cachegroup = com_ivanov_accounting_realm_groupRealmProxy.insertOrUpdate(realm, groupObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.groupIndex, rowIndex, cachegroup, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.groupIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.ivanov.accounting.realm.product.class);
        long tableNativePtr = table.getNativePtr();
        productColumnInfo columnInfo = (productColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.product.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.ivanov.accounting.realm.product object = null;
        while (objects.hasNext()) {
            object = (com.ivanov.accounting.realm.product) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$name = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$description = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
            }

            com.ivanov.accounting.realm.company companyObj = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$company();
            if (companyObj != null) {
                Long cachecompany = cache.get(companyObj);
                if (cachecompany == null) {
                    cachecompany = com_ivanov_accounting_realm_companyRealmProxy.insertOrUpdate(realm, companyObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.companyIndex, rowIndex, cachecompany, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.companyIndex, rowIndex);
            }

            com.ivanov.accounting.realm.group groupObj = ((com_ivanov_accounting_realm_productRealmProxyInterface) object).realmGet$group();
            if (groupObj != null) {
                Long cachegroup = cache.get(groupObj);
                if (cachegroup == null) {
                    cachegroup = com_ivanov_accounting_realm_groupRealmProxy.insertOrUpdate(realm, groupObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.groupIndex, rowIndex, cachegroup, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.groupIndex, rowIndex);
            }
        }
    }

    public static com.ivanov.accounting.realm.product createDetachedCopy(com.ivanov.accounting.realm.product realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.ivanov.accounting.realm.product unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.ivanov.accounting.realm.product();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.ivanov.accounting.realm.product) cachedObject.object;
            }
            unmanagedObject = (com.ivanov.accounting.realm.product) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_ivanov_accounting_realm_productRealmProxyInterface unmanagedCopy = (com_ivanov_accounting_realm_productRealmProxyInterface) unmanagedObject;
        com_ivanov_accounting_realm_productRealmProxyInterface realmSource = (com_ivanov_accounting_realm_productRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$description(realmSource.realmGet$description());

        // Deep copy of company
        unmanagedCopy.realmSet$company(com_ivanov_accounting_realm_companyRealmProxy.createDetachedCopy(realmSource.realmGet$company(), currentDepth + 1, maxDepth, cache));

        // Deep copy of group
        unmanagedCopy.realmSet$group(com_ivanov_accounting_realm_groupRealmProxy.createDetachedCopy(realmSource.realmGet$group(), currentDepth + 1, maxDepth, cache));

        return unmanagedObject;
    }

    static com.ivanov.accounting.realm.product update(Realm realm, com.ivanov.accounting.realm.product realmObject, com.ivanov.accounting.realm.product newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_ivanov_accounting_realm_productRealmProxyInterface realmObjectTarget = (com_ivanov_accounting_realm_productRealmProxyInterface) realmObject;
        com_ivanov_accounting_realm_productRealmProxyInterface realmObjectSource = (com_ivanov_accounting_realm_productRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$description(realmObjectSource.realmGet$description());
        com.ivanov.accounting.realm.company companyObj = realmObjectSource.realmGet$company();
        if (companyObj == null) {
            realmObjectTarget.realmSet$company(null);
        } else {
            com.ivanov.accounting.realm.company cachecompany = (com.ivanov.accounting.realm.company) cache.get(companyObj);
            if (cachecompany != null) {
                realmObjectTarget.realmSet$company(cachecompany);
            } else {
                realmObjectTarget.realmSet$company(com_ivanov_accounting_realm_companyRealmProxy.copyOrUpdate(realm, companyObj, true, cache));
            }
        }
        com.ivanov.accounting.realm.group groupObj = realmObjectSource.realmGet$group();
        if (groupObj == null) {
            realmObjectTarget.realmSet$group(null);
        } else {
            com.ivanov.accounting.realm.group cachegroup = (com.ivanov.accounting.realm.group) cache.get(groupObj);
            if (cachegroup != null) {
                realmObjectTarget.realmSet$group(cachegroup);
            } else {
                realmObjectTarget.realmSet$group(com_ivanov_accounting_realm_groupRealmProxy.copyOrUpdate(realm, groupObj, true, cache));
            }
        }
        return realmObject;
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_ivanov_accounting_realm_productRealmProxy aproduct = (com_ivanov_accounting_realm_productRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aproduct.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aproduct.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aproduct.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
