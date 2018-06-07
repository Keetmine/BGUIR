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
public class com_ivanov_accounting_realm_actionTypeRealmProxy extends com.ivanov.accounting.realm.actionType
    implements RealmObjectProxy, com_ivanov_accounting_realm_actionTypeRealmProxyInterface {

    static final class actionTypeColumnInfo extends ColumnInfo {
        long idIndex;
        long nameIndex;
        long descriptioinIndex;

        actionTypeColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("actionType");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.descriptioinIndex = addColumnDetails("descriptioin", "descriptioin", objectSchemaInfo);
        }

        actionTypeColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new actionTypeColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final actionTypeColumnInfo src = (actionTypeColumnInfo) rawSrc;
            final actionTypeColumnInfo dst = (actionTypeColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.nameIndex = src.nameIndex;
            dst.descriptioinIndex = src.descriptioinIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private actionTypeColumnInfo columnInfo;
    private ProxyState<com.ivanov.accounting.realm.actionType> proxyState;

    com_ivanov_accounting_realm_actionTypeRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (actionTypeColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.ivanov.accounting.realm.actionType>(this);
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
    public String realmGet$descriptioin() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descriptioinIndex);
    }

    @Override
    public void realmSet$descriptioin(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descriptioinIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descriptioinIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descriptioinIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descriptioinIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("actionType", 3, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("descriptioin", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static actionTypeColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new actionTypeColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "actionType";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "actionType";
    }

    @SuppressWarnings("cast")
    public static com.ivanov.accounting.realm.actionType createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.ivanov.accounting.realm.actionType obj = null;
        if (update) {
            Table table = realm.getTable(com.ivanov.accounting.realm.actionType.class);
            actionTypeColumnInfo columnInfo = (actionTypeColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.actionType.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.actionType.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy) realm.createObjectInternal(com.ivanov.accounting.realm.actionType.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy) realm.createObjectInternal(com.ivanov.accounting.realm.actionType.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_ivanov_accounting_realm_actionTypeRealmProxyInterface objProxy = (com_ivanov_accounting_realm_actionTypeRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("descriptioin")) {
            if (json.isNull("descriptioin")) {
                objProxy.realmSet$descriptioin(null);
            } else {
                objProxy.realmSet$descriptioin((String) json.getString("descriptioin"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.ivanov.accounting.realm.actionType createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.ivanov.accounting.realm.actionType obj = new com.ivanov.accounting.realm.actionType();
        final com_ivanov_accounting_realm_actionTypeRealmProxyInterface objProxy = (com_ivanov_accounting_realm_actionTypeRealmProxyInterface) obj;
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
            } else if (name.equals("descriptioin")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$descriptioin((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$descriptioin(null);
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

    public static com.ivanov.accounting.realm.actionType copyOrUpdate(Realm realm, com.ivanov.accounting.realm.actionType object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.ivanov.accounting.realm.actionType) cachedRealmObject;
        }

        com.ivanov.accounting.realm.actionType realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.ivanov.accounting.realm.actionType.class);
            actionTypeColumnInfo columnInfo = (actionTypeColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.actionType.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_ivanov_accounting_realm_actionTypeRealmProxyInterface) object).realmGet$id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.actionType.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.ivanov.accounting.realm.actionType copy(Realm realm, com.ivanov.accounting.realm.actionType newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.ivanov.accounting.realm.actionType) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.ivanov.accounting.realm.actionType realmObject = realm.createObjectInternal(com.ivanov.accounting.realm.actionType.class, ((com_ivanov_accounting_realm_actionTypeRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_ivanov_accounting_realm_actionTypeRealmProxyInterface realmObjectSource = (com_ivanov_accounting_realm_actionTypeRealmProxyInterface) newObject;
        com_ivanov_accounting_realm_actionTypeRealmProxyInterface realmObjectCopy = (com_ivanov_accounting_realm_actionTypeRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$descriptioin(realmObjectSource.realmGet$descriptioin());
        return realmObject;
    }

    public static long insert(Realm realm, com.ivanov.accounting.realm.actionType object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.ivanov.accounting.realm.actionType.class);
        long tableNativePtr = table.getNativePtr();
        actionTypeColumnInfo columnInfo = (actionTypeColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.actionType.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_ivanov_accounting_realm_actionTypeRealmProxyInterface) object).realmGet$id();
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
        String realmGet$name = ((com_ivanov_accounting_realm_actionTypeRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$descriptioin = ((com_ivanov_accounting_realm_actionTypeRealmProxyInterface) object).realmGet$descriptioin();
        if (realmGet$descriptioin != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptioinIndex, rowIndex, realmGet$descriptioin, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.ivanov.accounting.realm.actionType.class);
        long tableNativePtr = table.getNativePtr();
        actionTypeColumnInfo columnInfo = (actionTypeColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.actionType.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.ivanov.accounting.realm.actionType object = null;
        while (objects.hasNext()) {
            object = (com.ivanov.accounting.realm.actionType) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_ivanov_accounting_realm_actionTypeRealmProxyInterface) object).realmGet$id();
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
            String realmGet$name = ((com_ivanov_accounting_realm_actionTypeRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$descriptioin = ((com_ivanov_accounting_realm_actionTypeRealmProxyInterface) object).realmGet$descriptioin();
            if (realmGet$descriptioin != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptioinIndex, rowIndex, realmGet$descriptioin, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.ivanov.accounting.realm.actionType object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.ivanov.accounting.realm.actionType.class);
        long tableNativePtr = table.getNativePtr();
        actionTypeColumnInfo columnInfo = (actionTypeColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.actionType.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_ivanov_accounting_realm_actionTypeRealmProxyInterface) object).realmGet$id();
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
        String realmGet$name = ((com_ivanov_accounting_realm_actionTypeRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$descriptioin = ((com_ivanov_accounting_realm_actionTypeRealmProxyInterface) object).realmGet$descriptioin();
        if (realmGet$descriptioin != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptioinIndex, rowIndex, realmGet$descriptioin, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptioinIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.ivanov.accounting.realm.actionType.class);
        long tableNativePtr = table.getNativePtr();
        actionTypeColumnInfo columnInfo = (actionTypeColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.actionType.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.ivanov.accounting.realm.actionType object = null;
        while (objects.hasNext()) {
            object = (com.ivanov.accounting.realm.actionType) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_ivanov_accounting_realm_actionTypeRealmProxyInterface) object).realmGet$id();
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
            String realmGet$name = ((com_ivanov_accounting_realm_actionTypeRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$descriptioin = ((com_ivanov_accounting_realm_actionTypeRealmProxyInterface) object).realmGet$descriptioin();
            if (realmGet$descriptioin != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptioinIndex, rowIndex, realmGet$descriptioin, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descriptioinIndex, rowIndex, false);
            }
        }
    }

    public static com.ivanov.accounting.realm.actionType createDetachedCopy(com.ivanov.accounting.realm.actionType realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.ivanov.accounting.realm.actionType unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.ivanov.accounting.realm.actionType();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.ivanov.accounting.realm.actionType) cachedObject.object;
            }
            unmanagedObject = (com.ivanov.accounting.realm.actionType) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_ivanov_accounting_realm_actionTypeRealmProxyInterface unmanagedCopy = (com_ivanov_accounting_realm_actionTypeRealmProxyInterface) unmanagedObject;
        com_ivanov_accounting_realm_actionTypeRealmProxyInterface realmSource = (com_ivanov_accounting_realm_actionTypeRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$descriptioin(realmSource.realmGet$descriptioin());

        return unmanagedObject;
    }

    static com.ivanov.accounting.realm.actionType update(Realm realm, com.ivanov.accounting.realm.actionType realmObject, com.ivanov.accounting.realm.actionType newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_ivanov_accounting_realm_actionTypeRealmProxyInterface realmObjectTarget = (com_ivanov_accounting_realm_actionTypeRealmProxyInterface) realmObject;
        com_ivanov_accounting_realm_actionTypeRealmProxyInterface realmObjectSource = (com_ivanov_accounting_realm_actionTypeRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$descriptioin(realmObjectSource.realmGet$descriptioin());
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
        com_ivanov_accounting_realm_actionTypeRealmProxy aactionType = (com_ivanov_accounting_realm_actionTypeRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aactionType.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aactionType.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aactionType.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
