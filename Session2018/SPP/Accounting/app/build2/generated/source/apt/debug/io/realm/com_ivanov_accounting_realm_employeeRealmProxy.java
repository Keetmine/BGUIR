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
public class com_ivanov_accounting_realm_employeeRealmProxy extends com.ivanov.accounting.realm.employee
    implements RealmObjectProxy, com_ivanov_accounting_realm_employeeRealmProxyInterface {

    static final class employeeColumnInfo extends ColumnInfo {
        long idIndex;
        long fioIndex;

        employeeColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("employee");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.fioIndex = addColumnDetails("fio", "fio", objectSchemaInfo);
        }

        employeeColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new employeeColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final employeeColumnInfo src = (employeeColumnInfo) rawSrc;
            final employeeColumnInfo dst = (employeeColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.fioIndex = src.fioIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private employeeColumnInfo columnInfo;
    private ProxyState<com.ivanov.accounting.realm.employee> proxyState;

    com_ivanov_accounting_realm_employeeRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (employeeColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.ivanov.accounting.realm.employee>(this);
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
    public String realmGet$fio() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fioIndex);
    }

    @Override
    public void realmSet$fio(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fioIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fioIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fioIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("employee", 2, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fio", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static employeeColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new employeeColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "employee";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "employee";
    }

    @SuppressWarnings("cast")
    public static com.ivanov.accounting.realm.employee createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.ivanov.accounting.realm.employee obj = null;
        if (update) {
            Table table = realm.getTable(com.ivanov.accounting.realm.employee.class);
            employeeColumnInfo columnInfo = (employeeColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.employee.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.employee.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_ivanov_accounting_realm_employeeRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_ivanov_accounting_realm_employeeRealmProxy) realm.createObjectInternal(com.ivanov.accounting.realm.employee.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_ivanov_accounting_realm_employeeRealmProxy) realm.createObjectInternal(com.ivanov.accounting.realm.employee.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_ivanov_accounting_realm_employeeRealmProxyInterface objProxy = (com_ivanov_accounting_realm_employeeRealmProxyInterface) obj;
        if (json.has("fio")) {
            if (json.isNull("fio")) {
                objProxy.realmSet$fio(null);
            } else {
                objProxy.realmSet$fio((String) json.getString("fio"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.ivanov.accounting.realm.employee createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.ivanov.accounting.realm.employee obj = new com.ivanov.accounting.realm.employee();
        final com_ivanov_accounting_realm_employeeRealmProxyInterface objProxy = (com_ivanov_accounting_realm_employeeRealmProxyInterface) obj;
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
            } else if (name.equals("fio")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fio((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fio(null);
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

    public static com.ivanov.accounting.realm.employee copyOrUpdate(Realm realm, com.ivanov.accounting.realm.employee object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.ivanov.accounting.realm.employee) cachedRealmObject;
        }

        com.ivanov.accounting.realm.employee realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.ivanov.accounting.realm.employee.class);
            employeeColumnInfo columnInfo = (employeeColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.employee.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_ivanov_accounting_realm_employeeRealmProxyInterface) object).realmGet$id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.employee.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_ivanov_accounting_realm_employeeRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.ivanov.accounting.realm.employee copy(Realm realm, com.ivanov.accounting.realm.employee newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.ivanov.accounting.realm.employee) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.ivanov.accounting.realm.employee realmObject = realm.createObjectInternal(com.ivanov.accounting.realm.employee.class, ((com_ivanov_accounting_realm_employeeRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_ivanov_accounting_realm_employeeRealmProxyInterface realmObjectSource = (com_ivanov_accounting_realm_employeeRealmProxyInterface) newObject;
        com_ivanov_accounting_realm_employeeRealmProxyInterface realmObjectCopy = (com_ivanov_accounting_realm_employeeRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$fio(realmObjectSource.realmGet$fio());
        return realmObject;
    }

    public static long insert(Realm realm, com.ivanov.accounting.realm.employee object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.ivanov.accounting.realm.employee.class);
        long tableNativePtr = table.getNativePtr();
        employeeColumnInfo columnInfo = (employeeColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.employee.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_ivanov_accounting_realm_employeeRealmProxyInterface) object).realmGet$id();
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
        String realmGet$fio = ((com_ivanov_accounting_realm_employeeRealmProxyInterface) object).realmGet$fio();
        if (realmGet$fio != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fioIndex, rowIndex, realmGet$fio, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.ivanov.accounting.realm.employee.class);
        long tableNativePtr = table.getNativePtr();
        employeeColumnInfo columnInfo = (employeeColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.employee.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.ivanov.accounting.realm.employee object = null;
        while (objects.hasNext()) {
            object = (com.ivanov.accounting.realm.employee) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_ivanov_accounting_realm_employeeRealmProxyInterface) object).realmGet$id();
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
            String realmGet$fio = ((com_ivanov_accounting_realm_employeeRealmProxyInterface) object).realmGet$fio();
            if (realmGet$fio != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fioIndex, rowIndex, realmGet$fio, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.ivanov.accounting.realm.employee object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.ivanov.accounting.realm.employee.class);
        long tableNativePtr = table.getNativePtr();
        employeeColumnInfo columnInfo = (employeeColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.employee.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_ivanov_accounting_realm_employeeRealmProxyInterface) object).realmGet$id();
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
        String realmGet$fio = ((com_ivanov_accounting_realm_employeeRealmProxyInterface) object).realmGet$fio();
        if (realmGet$fio != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fioIndex, rowIndex, realmGet$fio, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fioIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.ivanov.accounting.realm.employee.class);
        long tableNativePtr = table.getNativePtr();
        employeeColumnInfo columnInfo = (employeeColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.employee.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.ivanov.accounting.realm.employee object = null;
        while (objects.hasNext()) {
            object = (com.ivanov.accounting.realm.employee) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_ivanov_accounting_realm_employeeRealmProxyInterface) object).realmGet$id();
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
            String realmGet$fio = ((com_ivanov_accounting_realm_employeeRealmProxyInterface) object).realmGet$fio();
            if (realmGet$fio != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fioIndex, rowIndex, realmGet$fio, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fioIndex, rowIndex, false);
            }
        }
    }

    public static com.ivanov.accounting.realm.employee createDetachedCopy(com.ivanov.accounting.realm.employee realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.ivanov.accounting.realm.employee unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.ivanov.accounting.realm.employee();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.ivanov.accounting.realm.employee) cachedObject.object;
            }
            unmanagedObject = (com.ivanov.accounting.realm.employee) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_ivanov_accounting_realm_employeeRealmProxyInterface unmanagedCopy = (com_ivanov_accounting_realm_employeeRealmProxyInterface) unmanagedObject;
        com_ivanov_accounting_realm_employeeRealmProxyInterface realmSource = (com_ivanov_accounting_realm_employeeRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$fio(realmSource.realmGet$fio());

        return unmanagedObject;
    }

    static com.ivanov.accounting.realm.employee update(Realm realm, com.ivanov.accounting.realm.employee realmObject, com.ivanov.accounting.realm.employee newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_ivanov_accounting_realm_employeeRealmProxyInterface realmObjectTarget = (com_ivanov_accounting_realm_employeeRealmProxyInterface) realmObject;
        com_ivanov_accounting_realm_employeeRealmProxyInterface realmObjectSource = (com_ivanov_accounting_realm_employeeRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$fio(realmObjectSource.realmGet$fio());
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
        com_ivanov_accounting_realm_employeeRealmProxy aemployee = (com_ivanov_accounting_realm_employeeRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aemployee.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aemployee.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aemployee.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
