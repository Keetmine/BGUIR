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
public class com_ivanov_accounting_realm_userRealmProxy extends com.ivanov.accounting.realm.user
    implements RealmObjectProxy, com_ivanov_accounting_realm_userRealmProxyInterface {

    static final class userColumnInfo extends ColumnInfo {
        long idIndex;
        long loginIndex;
        long passwordIndex;
        long roleIndex;

        userColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("user");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.loginIndex = addColumnDetails("login", "login", objectSchemaInfo);
            this.passwordIndex = addColumnDetails("password", "password", objectSchemaInfo);
            this.roleIndex = addColumnDetails("role", "role", objectSchemaInfo);
        }

        userColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new userColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final userColumnInfo src = (userColumnInfo) rawSrc;
            final userColumnInfo dst = (userColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.loginIndex = src.loginIndex;
            dst.passwordIndex = src.passwordIndex;
            dst.roleIndex = src.roleIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private userColumnInfo columnInfo;
    private ProxyState<com.ivanov.accounting.realm.user> proxyState;

    com_ivanov_accounting_realm_userRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (userColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.ivanov.accounting.realm.user>(this);
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
    public String realmGet$login() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.loginIndex);
    }

    @Override
    public void realmSet$login(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.loginIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.loginIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.loginIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.loginIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$password() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.passwordIndex);
    }

    @Override
    public void realmSet$password(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.passwordIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.passwordIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.passwordIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.passwordIndex, value);
    }

    @Override
    public com.ivanov.accounting.realm.role realmGet$role() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.roleIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.ivanov.accounting.realm.role.class, proxyState.getRow$realm().getLink(columnInfo.roleIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$role(com.ivanov.accounting.realm.role value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("role")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.roleIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.roleIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.roleIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.roleIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("user", 4, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("login", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("password", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("role", RealmFieldType.OBJECT, "role");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static userColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new userColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "user";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "user";
    }

    @SuppressWarnings("cast")
    public static com.ivanov.accounting.realm.user createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.ivanov.accounting.realm.user obj = null;
        if (update) {
            Table table = realm.getTable(com.ivanov.accounting.realm.user.class);
            userColumnInfo columnInfo = (userColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.user.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.user.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_ivanov_accounting_realm_userRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("role")) {
                excludeFields.add("role");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_ivanov_accounting_realm_userRealmProxy) realm.createObjectInternal(com.ivanov.accounting.realm.user.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_ivanov_accounting_realm_userRealmProxy) realm.createObjectInternal(com.ivanov.accounting.realm.user.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_ivanov_accounting_realm_userRealmProxyInterface objProxy = (com_ivanov_accounting_realm_userRealmProxyInterface) obj;
        if (json.has("login")) {
            if (json.isNull("login")) {
                objProxy.realmSet$login(null);
            } else {
                objProxy.realmSet$login((String) json.getString("login"));
            }
        }
        if (json.has("password")) {
            if (json.isNull("password")) {
                objProxy.realmSet$password(null);
            } else {
                objProxy.realmSet$password((String) json.getString("password"));
            }
        }
        if (json.has("role")) {
            if (json.isNull("role")) {
                objProxy.realmSet$role(null);
            } else {
                com.ivanov.accounting.realm.role roleObj = com_ivanov_accounting_realm_roleRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("role"), update);
                objProxy.realmSet$role(roleObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.ivanov.accounting.realm.user createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.ivanov.accounting.realm.user obj = new com.ivanov.accounting.realm.user();
        final com_ivanov_accounting_realm_userRealmProxyInterface objProxy = (com_ivanov_accounting_realm_userRealmProxyInterface) obj;
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
            } else if (name.equals("login")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$login((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$login(null);
                }
            } else if (name.equals("password")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$password((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$password(null);
                }
            } else if (name.equals("role")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$role(null);
                } else {
                    com.ivanov.accounting.realm.role roleObj = com_ivanov_accounting_realm_roleRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$role(roleObj);
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

    public static com.ivanov.accounting.realm.user copyOrUpdate(Realm realm, com.ivanov.accounting.realm.user object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.ivanov.accounting.realm.user) cachedRealmObject;
        }

        com.ivanov.accounting.realm.user realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.ivanov.accounting.realm.user.class);
            userColumnInfo columnInfo = (userColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.user.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.user.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_ivanov_accounting_realm_userRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.ivanov.accounting.realm.user copy(Realm realm, com.ivanov.accounting.realm.user newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.ivanov.accounting.realm.user) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.ivanov.accounting.realm.user realmObject = realm.createObjectInternal(com.ivanov.accounting.realm.user.class, ((com_ivanov_accounting_realm_userRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_ivanov_accounting_realm_userRealmProxyInterface realmObjectSource = (com_ivanov_accounting_realm_userRealmProxyInterface) newObject;
        com_ivanov_accounting_realm_userRealmProxyInterface realmObjectCopy = (com_ivanov_accounting_realm_userRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$login(realmObjectSource.realmGet$login());
        realmObjectCopy.realmSet$password(realmObjectSource.realmGet$password());

        com.ivanov.accounting.realm.role roleObj = realmObjectSource.realmGet$role();
        if (roleObj == null) {
            realmObjectCopy.realmSet$role(null);
        } else {
            com.ivanov.accounting.realm.role cacherole = (com.ivanov.accounting.realm.role) cache.get(roleObj);
            if (cacherole != null) {
                realmObjectCopy.realmSet$role(cacherole);
            } else {
                realmObjectCopy.realmSet$role(com_ivanov_accounting_realm_roleRealmProxy.copyOrUpdate(realm, roleObj, update, cache));
            }
        }
        return realmObject;
    }

    public static long insert(Realm realm, com.ivanov.accounting.realm.user object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.ivanov.accounting.realm.user.class);
        long tableNativePtr = table.getNativePtr();
        userColumnInfo columnInfo = (userColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.user.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$id();
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
        String realmGet$login = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$login();
        if (realmGet$login != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
        }
        String realmGet$password = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        }

        com.ivanov.accounting.realm.role roleObj = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$role();
        if (roleObj != null) {
            Long cacherole = cache.get(roleObj);
            if (cacherole == null) {
                cacherole = com_ivanov_accounting_realm_roleRealmProxy.insert(realm, roleObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.roleIndex, rowIndex, cacherole, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.ivanov.accounting.realm.user.class);
        long tableNativePtr = table.getNativePtr();
        userColumnInfo columnInfo = (userColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.user.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.ivanov.accounting.realm.user object = null;
        while (objects.hasNext()) {
            object = (com.ivanov.accounting.realm.user) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$id();
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
            String realmGet$login = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$login();
            if (realmGet$login != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
            }
            String realmGet$password = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
            }

            com.ivanov.accounting.realm.role roleObj = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$role();
            if (roleObj != null) {
                Long cacherole = cache.get(roleObj);
                if (cacherole == null) {
                    cacherole = com_ivanov_accounting_realm_roleRealmProxy.insert(realm, roleObj, cache);
                }
                table.setLink(columnInfo.roleIndex, rowIndex, cacherole, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.ivanov.accounting.realm.user object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.ivanov.accounting.realm.user.class);
        long tableNativePtr = table.getNativePtr();
        userColumnInfo columnInfo = (userColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.user.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$id();
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
        String realmGet$login = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$login();
        if (realmGet$login != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.loginIndex, rowIndex, false);
        }
        String realmGet$password = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
        }

        com.ivanov.accounting.realm.role roleObj = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$role();
        if (roleObj != null) {
            Long cacherole = cache.get(roleObj);
            if (cacherole == null) {
                cacherole = com_ivanov_accounting_realm_roleRealmProxy.insertOrUpdate(realm, roleObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.roleIndex, rowIndex, cacherole, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.roleIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.ivanov.accounting.realm.user.class);
        long tableNativePtr = table.getNativePtr();
        userColumnInfo columnInfo = (userColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.user.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.ivanov.accounting.realm.user object = null;
        while (objects.hasNext()) {
            object = (com.ivanov.accounting.realm.user) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$id();
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
            String realmGet$login = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$login();
            if (realmGet$login != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.loginIndex, rowIndex, realmGet$login, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.loginIndex, rowIndex, false);
            }
            String realmGet$password = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
            }

            com.ivanov.accounting.realm.role roleObj = ((com_ivanov_accounting_realm_userRealmProxyInterface) object).realmGet$role();
            if (roleObj != null) {
                Long cacherole = cache.get(roleObj);
                if (cacherole == null) {
                    cacherole = com_ivanov_accounting_realm_roleRealmProxy.insertOrUpdate(realm, roleObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.roleIndex, rowIndex, cacherole, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.roleIndex, rowIndex);
            }
        }
    }

    public static com.ivanov.accounting.realm.user createDetachedCopy(com.ivanov.accounting.realm.user realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.ivanov.accounting.realm.user unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.ivanov.accounting.realm.user();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.ivanov.accounting.realm.user) cachedObject.object;
            }
            unmanagedObject = (com.ivanov.accounting.realm.user) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_ivanov_accounting_realm_userRealmProxyInterface unmanagedCopy = (com_ivanov_accounting_realm_userRealmProxyInterface) unmanagedObject;
        com_ivanov_accounting_realm_userRealmProxyInterface realmSource = (com_ivanov_accounting_realm_userRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$login(realmSource.realmGet$login());
        unmanagedCopy.realmSet$password(realmSource.realmGet$password());

        // Deep copy of role
        unmanagedCopy.realmSet$role(com_ivanov_accounting_realm_roleRealmProxy.createDetachedCopy(realmSource.realmGet$role(), currentDepth + 1, maxDepth, cache));

        return unmanagedObject;
    }

    static com.ivanov.accounting.realm.user update(Realm realm, com.ivanov.accounting.realm.user realmObject, com.ivanov.accounting.realm.user newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_ivanov_accounting_realm_userRealmProxyInterface realmObjectTarget = (com_ivanov_accounting_realm_userRealmProxyInterface) realmObject;
        com_ivanov_accounting_realm_userRealmProxyInterface realmObjectSource = (com_ivanov_accounting_realm_userRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$login(realmObjectSource.realmGet$login());
        realmObjectTarget.realmSet$password(realmObjectSource.realmGet$password());
        com.ivanov.accounting.realm.role roleObj = realmObjectSource.realmGet$role();
        if (roleObj == null) {
            realmObjectTarget.realmSet$role(null);
        } else {
            com.ivanov.accounting.realm.role cacherole = (com.ivanov.accounting.realm.role) cache.get(roleObj);
            if (cacherole != null) {
                realmObjectTarget.realmSet$role(cacherole);
            } else {
                realmObjectTarget.realmSet$role(com_ivanov_accounting_realm_roleRealmProxy.copyOrUpdate(realm, roleObj, true, cache));
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
        com_ivanov_accounting_realm_userRealmProxy auser = (com_ivanov_accounting_realm_userRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = auser.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = auser.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != auser.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
