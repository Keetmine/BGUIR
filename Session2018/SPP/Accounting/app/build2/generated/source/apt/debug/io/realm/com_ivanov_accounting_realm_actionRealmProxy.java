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
public class com_ivanov_accounting_realm_actionRealmProxy extends com.ivanov.accounting.realm.action
    implements RealmObjectProxy, com_ivanov_accounting_realm_actionRealmProxyInterface {

    static final class actionColumnInfo extends ColumnInfo {
        long idIndex;
        long actionTypeIndex;
        long productIndex;
        long priceIndex;
        long descriptionIndex;
        long employeeIndex;
        long reasonIndex;
        long statusIndex;

        actionColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("action");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.actionTypeIndex = addColumnDetails("actionType", "actionType", objectSchemaInfo);
            this.productIndex = addColumnDetails("product", "product", objectSchemaInfo);
            this.priceIndex = addColumnDetails("price", "price", objectSchemaInfo);
            this.descriptionIndex = addColumnDetails("description", "description", objectSchemaInfo);
            this.employeeIndex = addColumnDetails("employee", "employee", objectSchemaInfo);
            this.reasonIndex = addColumnDetails("reason", "reason", objectSchemaInfo);
            this.statusIndex = addColumnDetails("status", "status", objectSchemaInfo);
        }

        actionColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new actionColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final actionColumnInfo src = (actionColumnInfo) rawSrc;
            final actionColumnInfo dst = (actionColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.actionTypeIndex = src.actionTypeIndex;
            dst.productIndex = src.productIndex;
            dst.priceIndex = src.priceIndex;
            dst.descriptionIndex = src.descriptionIndex;
            dst.employeeIndex = src.employeeIndex;
            dst.reasonIndex = src.reasonIndex;
            dst.statusIndex = src.statusIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private actionColumnInfo columnInfo;
    private ProxyState<com.ivanov.accounting.realm.action> proxyState;

    com_ivanov_accounting_realm_actionRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (actionColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.ivanov.accounting.realm.action>(this);
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
    public com.ivanov.accounting.realm.actionType realmGet$actionType() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.actionTypeIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.ivanov.accounting.realm.actionType.class, proxyState.getRow$realm().getLink(columnInfo.actionTypeIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$actionType(com.ivanov.accounting.realm.actionType value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("actionType")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.actionTypeIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.actionTypeIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.actionTypeIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.actionTypeIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.ivanov.accounting.realm.product realmGet$product() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.productIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.ivanov.accounting.realm.product.class, proxyState.getRow$realm().getLink(columnInfo.productIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$product(com.ivanov.accounting.realm.product value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("product")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.productIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.productIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.productIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.productIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$price() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.priceIndex);
    }

    @Override
    public void realmSet$price(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.priceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.priceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.priceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.priceIndex, value);
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
    public com.ivanov.accounting.realm.employee realmGet$employee() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.employeeIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.ivanov.accounting.realm.employee.class, proxyState.getRow$realm().getLink(columnInfo.employeeIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$employee(com.ivanov.accounting.realm.employee value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("employee")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.employeeIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.employeeIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.employeeIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.employeeIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.ivanov.accounting.realm.reason realmGet$reason() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.reasonIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.ivanov.accounting.realm.reason.class, proxyState.getRow$realm().getLink(columnInfo.reasonIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$reason(com.ivanov.accounting.realm.reason value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("reason")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.reasonIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.reasonIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.reasonIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.reasonIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.ivanov.accounting.realm.status realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.statusIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.ivanov.accounting.realm.status.class, proxyState.getRow$realm().getLink(columnInfo.statusIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$status(com.ivanov.accounting.realm.status value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("status")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.statusIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.statusIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.statusIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.statusIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("action", 8, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("actionType", RealmFieldType.OBJECT, "actionType");
        builder.addPersistedLinkProperty("product", RealmFieldType.OBJECT, "product");
        builder.addPersistedProperty("price", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("employee", RealmFieldType.OBJECT, "employee");
        builder.addPersistedLinkProperty("reason", RealmFieldType.OBJECT, "reason");
        builder.addPersistedLinkProperty("status", RealmFieldType.OBJECT, "status");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static actionColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new actionColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "action";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "action";
    }

    @SuppressWarnings("cast")
    public static com.ivanov.accounting.realm.action createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(5);
        com.ivanov.accounting.realm.action obj = null;
        if (update) {
            Table table = realm.getTable(com.ivanov.accounting.realm.action.class);
            actionColumnInfo columnInfo = (actionColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.action.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.action.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_ivanov_accounting_realm_actionRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("actionType")) {
                excludeFields.add("actionType");
            }
            if (json.has("product")) {
                excludeFields.add("product");
            }
            if (json.has("employee")) {
                excludeFields.add("employee");
            }
            if (json.has("reason")) {
                excludeFields.add("reason");
            }
            if (json.has("status")) {
                excludeFields.add("status");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_ivanov_accounting_realm_actionRealmProxy) realm.createObjectInternal(com.ivanov.accounting.realm.action.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_ivanov_accounting_realm_actionRealmProxy) realm.createObjectInternal(com.ivanov.accounting.realm.action.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_ivanov_accounting_realm_actionRealmProxyInterface objProxy = (com_ivanov_accounting_realm_actionRealmProxyInterface) obj;
        if (json.has("actionType")) {
            if (json.isNull("actionType")) {
                objProxy.realmSet$actionType(null);
            } else {
                com.ivanov.accounting.realm.actionType actionTypeObj = com_ivanov_accounting_realm_actionTypeRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("actionType"), update);
                objProxy.realmSet$actionType(actionTypeObj);
            }
        }
        if (json.has("product")) {
            if (json.isNull("product")) {
                objProxy.realmSet$product(null);
            } else {
                com.ivanov.accounting.realm.product productObj = com_ivanov_accounting_realm_productRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("product"), update);
                objProxy.realmSet$product(productObj);
            }
        }
        if (json.has("price")) {
            if (json.isNull("price")) {
                objProxy.realmSet$price(null);
            } else {
                objProxy.realmSet$price((String) json.getString("price"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                objProxy.realmSet$description(null);
            } else {
                objProxy.realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("employee")) {
            if (json.isNull("employee")) {
                objProxy.realmSet$employee(null);
            } else {
                com.ivanov.accounting.realm.employee employeeObj = com_ivanov_accounting_realm_employeeRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("employee"), update);
                objProxy.realmSet$employee(employeeObj);
            }
        }
        if (json.has("reason")) {
            if (json.isNull("reason")) {
                objProxy.realmSet$reason(null);
            } else {
                com.ivanov.accounting.realm.reason reasonObj = com_ivanov_accounting_realm_reasonRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("reason"), update);
                objProxy.realmSet$reason(reasonObj);
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                objProxy.realmSet$status(null);
            } else {
                com.ivanov.accounting.realm.status statusObj = com_ivanov_accounting_realm_statusRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("status"), update);
                objProxy.realmSet$status(statusObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.ivanov.accounting.realm.action createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.ivanov.accounting.realm.action obj = new com.ivanov.accounting.realm.action();
        final com_ivanov_accounting_realm_actionRealmProxyInterface objProxy = (com_ivanov_accounting_realm_actionRealmProxyInterface) obj;
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
            } else if (name.equals("actionType")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$actionType(null);
                } else {
                    com.ivanov.accounting.realm.actionType actionTypeObj = com_ivanov_accounting_realm_actionTypeRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$actionType(actionTypeObj);
                }
            } else if (name.equals("product")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$product(null);
                } else {
                    com.ivanov.accounting.realm.product productObj = com_ivanov_accounting_realm_productRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$product(productObj);
                }
            } else if (name.equals("price")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$price((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$price(null);
                }
            } else if (name.equals("description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$description(null);
                }
            } else if (name.equals("employee")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$employee(null);
                } else {
                    com.ivanov.accounting.realm.employee employeeObj = com_ivanov_accounting_realm_employeeRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$employee(employeeObj);
                }
            } else if (name.equals("reason")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$reason(null);
                } else {
                    com.ivanov.accounting.realm.reason reasonObj = com_ivanov_accounting_realm_reasonRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$reason(reasonObj);
                }
            } else if (name.equals("status")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$status(null);
                } else {
                    com.ivanov.accounting.realm.status statusObj = com_ivanov_accounting_realm_statusRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$status(statusObj);
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

    public static com.ivanov.accounting.realm.action copyOrUpdate(Realm realm, com.ivanov.accounting.realm.action object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.ivanov.accounting.realm.action) cachedRealmObject;
        }

        com.ivanov.accounting.realm.action realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.ivanov.accounting.realm.action.class);
            actionColumnInfo columnInfo = (actionColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.action.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.action.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_ivanov_accounting_realm_actionRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.ivanov.accounting.realm.action copy(Realm realm, com.ivanov.accounting.realm.action newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.ivanov.accounting.realm.action) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.ivanov.accounting.realm.action realmObject = realm.createObjectInternal(com.ivanov.accounting.realm.action.class, ((com_ivanov_accounting_realm_actionRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_ivanov_accounting_realm_actionRealmProxyInterface realmObjectSource = (com_ivanov_accounting_realm_actionRealmProxyInterface) newObject;
        com_ivanov_accounting_realm_actionRealmProxyInterface realmObjectCopy = (com_ivanov_accounting_realm_actionRealmProxyInterface) realmObject;


        com.ivanov.accounting.realm.actionType actionTypeObj = realmObjectSource.realmGet$actionType();
        if (actionTypeObj == null) {
            realmObjectCopy.realmSet$actionType(null);
        } else {
            com.ivanov.accounting.realm.actionType cacheactionType = (com.ivanov.accounting.realm.actionType) cache.get(actionTypeObj);
            if (cacheactionType != null) {
                realmObjectCopy.realmSet$actionType(cacheactionType);
            } else {
                realmObjectCopy.realmSet$actionType(com_ivanov_accounting_realm_actionTypeRealmProxy.copyOrUpdate(realm, actionTypeObj, update, cache));
            }
        }

        com.ivanov.accounting.realm.product productObj = realmObjectSource.realmGet$product();
        if (productObj == null) {
            realmObjectCopy.realmSet$product(null);
        } else {
            com.ivanov.accounting.realm.product cacheproduct = (com.ivanov.accounting.realm.product) cache.get(productObj);
            if (cacheproduct != null) {
                realmObjectCopy.realmSet$product(cacheproduct);
            } else {
                realmObjectCopy.realmSet$product(com_ivanov_accounting_realm_productRealmProxy.copyOrUpdate(realm, productObj, update, cache));
            }
        }
        realmObjectCopy.realmSet$price(realmObjectSource.realmGet$price());
        realmObjectCopy.realmSet$description(realmObjectSource.realmGet$description());

        com.ivanov.accounting.realm.employee employeeObj = realmObjectSource.realmGet$employee();
        if (employeeObj == null) {
            realmObjectCopy.realmSet$employee(null);
        } else {
            com.ivanov.accounting.realm.employee cacheemployee = (com.ivanov.accounting.realm.employee) cache.get(employeeObj);
            if (cacheemployee != null) {
                realmObjectCopy.realmSet$employee(cacheemployee);
            } else {
                realmObjectCopy.realmSet$employee(com_ivanov_accounting_realm_employeeRealmProxy.copyOrUpdate(realm, employeeObj, update, cache));
            }
        }

        com.ivanov.accounting.realm.reason reasonObj = realmObjectSource.realmGet$reason();
        if (reasonObj == null) {
            realmObjectCopy.realmSet$reason(null);
        } else {
            com.ivanov.accounting.realm.reason cachereason = (com.ivanov.accounting.realm.reason) cache.get(reasonObj);
            if (cachereason != null) {
                realmObjectCopy.realmSet$reason(cachereason);
            } else {
                realmObjectCopy.realmSet$reason(com_ivanov_accounting_realm_reasonRealmProxy.copyOrUpdate(realm, reasonObj, update, cache));
            }
        }

        com.ivanov.accounting.realm.status statusObj = realmObjectSource.realmGet$status();
        if (statusObj == null) {
            realmObjectCopy.realmSet$status(null);
        } else {
            com.ivanov.accounting.realm.status cachestatus = (com.ivanov.accounting.realm.status) cache.get(statusObj);
            if (cachestatus != null) {
                realmObjectCopy.realmSet$status(cachestatus);
            } else {
                realmObjectCopy.realmSet$status(com_ivanov_accounting_realm_statusRealmProxy.copyOrUpdate(realm, statusObj, update, cache));
            }
        }
        return realmObject;
    }

    public static long insert(Realm realm, com.ivanov.accounting.realm.action object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.ivanov.accounting.realm.action.class);
        long tableNativePtr = table.getNativePtr();
        actionColumnInfo columnInfo = (actionColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.action.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$id();
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

        com.ivanov.accounting.realm.actionType actionTypeObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$actionType();
        if (actionTypeObj != null) {
            Long cacheactionType = cache.get(actionTypeObj);
            if (cacheactionType == null) {
                cacheactionType = com_ivanov_accounting_realm_actionTypeRealmProxy.insert(realm, actionTypeObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.actionTypeIndex, rowIndex, cacheactionType, false);
        }

        com.ivanov.accounting.realm.product productObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$product();
        if (productObj != null) {
            Long cacheproduct = cache.get(productObj);
            if (cacheproduct == null) {
                cacheproduct = com_ivanov_accounting_realm_productRealmProxy.insert(realm, productObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.productIndex, rowIndex, cacheproduct, false);
        }
        String realmGet$price = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$price();
        if (realmGet$price != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.priceIndex, rowIndex, realmGet$price, false);
        }
        String realmGet$description = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }

        com.ivanov.accounting.realm.employee employeeObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$employee();
        if (employeeObj != null) {
            Long cacheemployee = cache.get(employeeObj);
            if (cacheemployee == null) {
                cacheemployee = com_ivanov_accounting_realm_employeeRealmProxy.insert(realm, employeeObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.employeeIndex, rowIndex, cacheemployee, false);
        }

        com.ivanov.accounting.realm.reason reasonObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$reason();
        if (reasonObj != null) {
            Long cachereason = cache.get(reasonObj);
            if (cachereason == null) {
                cachereason = com_ivanov_accounting_realm_reasonRealmProxy.insert(realm, reasonObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.reasonIndex, rowIndex, cachereason, false);
        }

        com.ivanov.accounting.realm.status statusObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$status();
        if (statusObj != null) {
            Long cachestatus = cache.get(statusObj);
            if (cachestatus == null) {
                cachestatus = com_ivanov_accounting_realm_statusRealmProxy.insert(realm, statusObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.statusIndex, rowIndex, cachestatus, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.ivanov.accounting.realm.action.class);
        long tableNativePtr = table.getNativePtr();
        actionColumnInfo columnInfo = (actionColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.action.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.ivanov.accounting.realm.action object = null;
        while (objects.hasNext()) {
            object = (com.ivanov.accounting.realm.action) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$id();
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

            com.ivanov.accounting.realm.actionType actionTypeObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$actionType();
            if (actionTypeObj != null) {
                Long cacheactionType = cache.get(actionTypeObj);
                if (cacheactionType == null) {
                    cacheactionType = com_ivanov_accounting_realm_actionTypeRealmProxy.insert(realm, actionTypeObj, cache);
                }
                table.setLink(columnInfo.actionTypeIndex, rowIndex, cacheactionType, false);
            }

            com.ivanov.accounting.realm.product productObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$product();
            if (productObj != null) {
                Long cacheproduct = cache.get(productObj);
                if (cacheproduct == null) {
                    cacheproduct = com_ivanov_accounting_realm_productRealmProxy.insert(realm, productObj, cache);
                }
                table.setLink(columnInfo.productIndex, rowIndex, cacheproduct, false);
            }
            String realmGet$price = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$price();
            if (realmGet$price != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.priceIndex, rowIndex, realmGet$price, false);
            }
            String realmGet$description = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            }

            com.ivanov.accounting.realm.employee employeeObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$employee();
            if (employeeObj != null) {
                Long cacheemployee = cache.get(employeeObj);
                if (cacheemployee == null) {
                    cacheemployee = com_ivanov_accounting_realm_employeeRealmProxy.insert(realm, employeeObj, cache);
                }
                table.setLink(columnInfo.employeeIndex, rowIndex, cacheemployee, false);
            }

            com.ivanov.accounting.realm.reason reasonObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$reason();
            if (reasonObj != null) {
                Long cachereason = cache.get(reasonObj);
                if (cachereason == null) {
                    cachereason = com_ivanov_accounting_realm_reasonRealmProxy.insert(realm, reasonObj, cache);
                }
                table.setLink(columnInfo.reasonIndex, rowIndex, cachereason, false);
            }

            com.ivanov.accounting.realm.status statusObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$status();
            if (statusObj != null) {
                Long cachestatus = cache.get(statusObj);
                if (cachestatus == null) {
                    cachestatus = com_ivanov_accounting_realm_statusRealmProxy.insert(realm, statusObj, cache);
                }
                table.setLink(columnInfo.statusIndex, rowIndex, cachestatus, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.ivanov.accounting.realm.action object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.ivanov.accounting.realm.action.class);
        long tableNativePtr = table.getNativePtr();
        actionColumnInfo columnInfo = (actionColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.action.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$id();
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

        com.ivanov.accounting.realm.actionType actionTypeObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$actionType();
        if (actionTypeObj != null) {
            Long cacheactionType = cache.get(actionTypeObj);
            if (cacheactionType == null) {
                cacheactionType = com_ivanov_accounting_realm_actionTypeRealmProxy.insertOrUpdate(realm, actionTypeObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.actionTypeIndex, rowIndex, cacheactionType, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.actionTypeIndex, rowIndex);
        }

        com.ivanov.accounting.realm.product productObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$product();
        if (productObj != null) {
            Long cacheproduct = cache.get(productObj);
            if (cacheproduct == null) {
                cacheproduct = com_ivanov_accounting_realm_productRealmProxy.insertOrUpdate(realm, productObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.productIndex, rowIndex, cacheproduct, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.productIndex, rowIndex);
        }
        String realmGet$price = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$price();
        if (realmGet$price != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.priceIndex, rowIndex, realmGet$price, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.priceIndex, rowIndex, false);
        }
        String realmGet$description = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }

        com.ivanov.accounting.realm.employee employeeObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$employee();
        if (employeeObj != null) {
            Long cacheemployee = cache.get(employeeObj);
            if (cacheemployee == null) {
                cacheemployee = com_ivanov_accounting_realm_employeeRealmProxy.insertOrUpdate(realm, employeeObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.employeeIndex, rowIndex, cacheemployee, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.employeeIndex, rowIndex);
        }

        com.ivanov.accounting.realm.reason reasonObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$reason();
        if (reasonObj != null) {
            Long cachereason = cache.get(reasonObj);
            if (cachereason == null) {
                cachereason = com_ivanov_accounting_realm_reasonRealmProxy.insertOrUpdate(realm, reasonObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.reasonIndex, rowIndex, cachereason, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.reasonIndex, rowIndex);
        }

        com.ivanov.accounting.realm.status statusObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$status();
        if (statusObj != null) {
            Long cachestatus = cache.get(statusObj);
            if (cachestatus == null) {
                cachestatus = com_ivanov_accounting_realm_statusRealmProxy.insertOrUpdate(realm, statusObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.statusIndex, rowIndex, cachestatus, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.statusIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.ivanov.accounting.realm.action.class);
        long tableNativePtr = table.getNativePtr();
        actionColumnInfo columnInfo = (actionColumnInfo) realm.getSchema().getColumnInfo(com.ivanov.accounting.realm.action.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.ivanov.accounting.realm.action object = null;
        while (objects.hasNext()) {
            object = (com.ivanov.accounting.realm.action) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$id();
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

            com.ivanov.accounting.realm.actionType actionTypeObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$actionType();
            if (actionTypeObj != null) {
                Long cacheactionType = cache.get(actionTypeObj);
                if (cacheactionType == null) {
                    cacheactionType = com_ivanov_accounting_realm_actionTypeRealmProxy.insertOrUpdate(realm, actionTypeObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.actionTypeIndex, rowIndex, cacheactionType, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.actionTypeIndex, rowIndex);
            }

            com.ivanov.accounting.realm.product productObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$product();
            if (productObj != null) {
                Long cacheproduct = cache.get(productObj);
                if (cacheproduct == null) {
                    cacheproduct = com_ivanov_accounting_realm_productRealmProxy.insertOrUpdate(realm, productObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.productIndex, rowIndex, cacheproduct, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.productIndex, rowIndex);
            }
            String realmGet$price = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$price();
            if (realmGet$price != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.priceIndex, rowIndex, realmGet$price, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.priceIndex, rowIndex, false);
            }
            String realmGet$description = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
            }

            com.ivanov.accounting.realm.employee employeeObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$employee();
            if (employeeObj != null) {
                Long cacheemployee = cache.get(employeeObj);
                if (cacheemployee == null) {
                    cacheemployee = com_ivanov_accounting_realm_employeeRealmProxy.insertOrUpdate(realm, employeeObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.employeeIndex, rowIndex, cacheemployee, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.employeeIndex, rowIndex);
            }

            com.ivanov.accounting.realm.reason reasonObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$reason();
            if (reasonObj != null) {
                Long cachereason = cache.get(reasonObj);
                if (cachereason == null) {
                    cachereason = com_ivanov_accounting_realm_reasonRealmProxy.insertOrUpdate(realm, reasonObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.reasonIndex, rowIndex, cachereason, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.reasonIndex, rowIndex);
            }

            com.ivanov.accounting.realm.status statusObj = ((com_ivanov_accounting_realm_actionRealmProxyInterface) object).realmGet$status();
            if (statusObj != null) {
                Long cachestatus = cache.get(statusObj);
                if (cachestatus == null) {
                    cachestatus = com_ivanov_accounting_realm_statusRealmProxy.insertOrUpdate(realm, statusObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.statusIndex, rowIndex, cachestatus, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.statusIndex, rowIndex);
            }
        }
    }

    public static com.ivanov.accounting.realm.action createDetachedCopy(com.ivanov.accounting.realm.action realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.ivanov.accounting.realm.action unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.ivanov.accounting.realm.action();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.ivanov.accounting.realm.action) cachedObject.object;
            }
            unmanagedObject = (com.ivanov.accounting.realm.action) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_ivanov_accounting_realm_actionRealmProxyInterface unmanagedCopy = (com_ivanov_accounting_realm_actionRealmProxyInterface) unmanagedObject;
        com_ivanov_accounting_realm_actionRealmProxyInterface realmSource = (com_ivanov_accounting_realm_actionRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());

        // Deep copy of actionType
        unmanagedCopy.realmSet$actionType(com_ivanov_accounting_realm_actionTypeRealmProxy.createDetachedCopy(realmSource.realmGet$actionType(), currentDepth + 1, maxDepth, cache));

        // Deep copy of product
        unmanagedCopy.realmSet$product(com_ivanov_accounting_realm_productRealmProxy.createDetachedCopy(realmSource.realmGet$product(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$price(realmSource.realmGet$price());
        unmanagedCopy.realmSet$description(realmSource.realmGet$description());

        // Deep copy of employee
        unmanagedCopy.realmSet$employee(com_ivanov_accounting_realm_employeeRealmProxy.createDetachedCopy(realmSource.realmGet$employee(), currentDepth + 1, maxDepth, cache));

        // Deep copy of reason
        unmanagedCopy.realmSet$reason(com_ivanov_accounting_realm_reasonRealmProxy.createDetachedCopy(realmSource.realmGet$reason(), currentDepth + 1, maxDepth, cache));

        // Deep copy of status
        unmanagedCopy.realmSet$status(com_ivanov_accounting_realm_statusRealmProxy.createDetachedCopy(realmSource.realmGet$status(), currentDepth + 1, maxDepth, cache));

        return unmanagedObject;
    }

    static com.ivanov.accounting.realm.action update(Realm realm, com.ivanov.accounting.realm.action realmObject, com.ivanov.accounting.realm.action newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_ivanov_accounting_realm_actionRealmProxyInterface realmObjectTarget = (com_ivanov_accounting_realm_actionRealmProxyInterface) realmObject;
        com_ivanov_accounting_realm_actionRealmProxyInterface realmObjectSource = (com_ivanov_accounting_realm_actionRealmProxyInterface) newObject;
        com.ivanov.accounting.realm.actionType actionTypeObj = realmObjectSource.realmGet$actionType();
        if (actionTypeObj == null) {
            realmObjectTarget.realmSet$actionType(null);
        } else {
            com.ivanov.accounting.realm.actionType cacheactionType = (com.ivanov.accounting.realm.actionType) cache.get(actionTypeObj);
            if (cacheactionType != null) {
                realmObjectTarget.realmSet$actionType(cacheactionType);
            } else {
                realmObjectTarget.realmSet$actionType(com_ivanov_accounting_realm_actionTypeRealmProxy.copyOrUpdate(realm, actionTypeObj, true, cache));
            }
        }
        com.ivanov.accounting.realm.product productObj = realmObjectSource.realmGet$product();
        if (productObj == null) {
            realmObjectTarget.realmSet$product(null);
        } else {
            com.ivanov.accounting.realm.product cacheproduct = (com.ivanov.accounting.realm.product) cache.get(productObj);
            if (cacheproduct != null) {
                realmObjectTarget.realmSet$product(cacheproduct);
            } else {
                realmObjectTarget.realmSet$product(com_ivanov_accounting_realm_productRealmProxy.copyOrUpdate(realm, productObj, true, cache));
            }
        }
        realmObjectTarget.realmSet$price(realmObjectSource.realmGet$price());
        realmObjectTarget.realmSet$description(realmObjectSource.realmGet$description());
        com.ivanov.accounting.realm.employee employeeObj = realmObjectSource.realmGet$employee();
        if (employeeObj == null) {
            realmObjectTarget.realmSet$employee(null);
        } else {
            com.ivanov.accounting.realm.employee cacheemployee = (com.ivanov.accounting.realm.employee) cache.get(employeeObj);
            if (cacheemployee != null) {
                realmObjectTarget.realmSet$employee(cacheemployee);
            } else {
                realmObjectTarget.realmSet$employee(com_ivanov_accounting_realm_employeeRealmProxy.copyOrUpdate(realm, employeeObj, true, cache));
            }
        }
        com.ivanov.accounting.realm.reason reasonObj = realmObjectSource.realmGet$reason();
        if (reasonObj == null) {
            realmObjectTarget.realmSet$reason(null);
        } else {
            com.ivanov.accounting.realm.reason cachereason = (com.ivanov.accounting.realm.reason) cache.get(reasonObj);
            if (cachereason != null) {
                realmObjectTarget.realmSet$reason(cachereason);
            } else {
                realmObjectTarget.realmSet$reason(com_ivanov_accounting_realm_reasonRealmProxy.copyOrUpdate(realm, reasonObj, true, cache));
            }
        }
        com.ivanov.accounting.realm.status statusObj = realmObjectSource.realmGet$status();
        if (statusObj == null) {
            realmObjectTarget.realmSet$status(null);
        } else {
            com.ivanov.accounting.realm.status cachestatus = (com.ivanov.accounting.realm.status) cache.get(statusObj);
            if (cachestatus != null) {
                realmObjectTarget.realmSet$status(cachestatus);
            } else {
                realmObjectTarget.realmSet$status(com_ivanov_accounting_realm_statusRealmProxy.copyOrUpdate(realm, statusObj, true, cache));
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
        com_ivanov_accounting_realm_actionRealmProxy aaction = (com_ivanov_accounting_realm_actionRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aaction.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aaction.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aaction.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
