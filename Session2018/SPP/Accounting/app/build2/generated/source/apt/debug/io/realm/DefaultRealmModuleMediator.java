package io.realm;


import android.util.JsonReader;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(10);
        modelClasses.add(com.ivanov.accounting.realm.action.class);
        modelClasses.add(com.ivanov.accounting.realm.actionType.class);
        modelClasses.add(com.ivanov.accounting.realm.company.class);
        modelClasses.add(com.ivanov.accounting.realm.employee.class);
        modelClasses.add(com.ivanov.accounting.realm.group.class);
        modelClasses.add(com.ivanov.accounting.realm.product.class);
        modelClasses.add(com.ivanov.accounting.realm.reason.class);
        modelClasses.add(com.ivanov.accounting.realm.role.class);
        modelClasses.add(com.ivanov.accounting.realm.status.class);
        modelClasses.add(com.ivanov.accounting.realm.user.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(10);
        infoMap.put(com.ivanov.accounting.realm.action.class, io.realm.com_ivanov_accounting_realm_actionRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.ivanov.accounting.realm.actionType.class, io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.ivanov.accounting.realm.company.class, io.realm.com_ivanov_accounting_realm_companyRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.ivanov.accounting.realm.employee.class, io.realm.com_ivanov_accounting_realm_employeeRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.ivanov.accounting.realm.group.class, io.realm.com_ivanov_accounting_realm_groupRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.ivanov.accounting.realm.product.class, io.realm.com_ivanov_accounting_realm_productRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.ivanov.accounting.realm.reason.class, io.realm.com_ivanov_accounting_realm_reasonRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.ivanov.accounting.realm.role.class, io.realm.com_ivanov_accounting_realm_roleRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.ivanov.accounting.realm.status.class, io.realm.com_ivanov_accounting_realm_statusRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.ivanov.accounting.realm.user.class, io.realm.com_ivanov_accounting_realm_userRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.ivanov.accounting.realm.action.class)) {
            return io.realm.com_ivanov_accounting_realm_actionRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.ivanov.accounting.realm.actionType.class)) {
            return io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.ivanov.accounting.realm.company.class)) {
            return io.realm.com_ivanov_accounting_realm_companyRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.ivanov.accounting.realm.employee.class)) {
            return io.realm.com_ivanov_accounting_realm_employeeRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.ivanov.accounting.realm.group.class)) {
            return io.realm.com_ivanov_accounting_realm_groupRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.ivanov.accounting.realm.product.class)) {
            return io.realm.com_ivanov_accounting_realm_productRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.ivanov.accounting.realm.reason.class)) {
            return io.realm.com_ivanov_accounting_realm_reasonRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.ivanov.accounting.realm.role.class)) {
            return io.realm.com_ivanov_accounting_realm_roleRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.ivanov.accounting.realm.status.class)) {
            return io.realm.com_ivanov_accounting_realm_statusRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.ivanov.accounting.realm.user.class)) {
            return io.realm.com_ivanov_accounting_realm_userRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.ivanov.accounting.realm.action.class)) {
            return "action";
        }
        if (clazz.equals(com.ivanov.accounting.realm.actionType.class)) {
            return "actionType";
        }
        if (clazz.equals(com.ivanov.accounting.realm.company.class)) {
            return "company";
        }
        if (clazz.equals(com.ivanov.accounting.realm.employee.class)) {
            return "employee";
        }
        if (clazz.equals(com.ivanov.accounting.realm.group.class)) {
            return "group";
        }
        if (clazz.equals(com.ivanov.accounting.realm.product.class)) {
            return "product";
        }
        if (clazz.equals(com.ivanov.accounting.realm.reason.class)) {
            return "reason";
        }
        if (clazz.equals(com.ivanov.accounting.realm.role.class)) {
            return "role";
        }
        if (clazz.equals(com.ivanov.accounting.realm.status.class)) {
            return "status";
        }
        if (clazz.equals(com.ivanov.accounting.realm.user.class)) {
            return "user";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.ivanov.accounting.realm.action.class)) {
                return clazz.cast(new io.realm.com_ivanov_accounting_realm_actionRealmProxy());
            }
            if (clazz.equals(com.ivanov.accounting.realm.actionType.class)) {
                return clazz.cast(new io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy());
            }
            if (clazz.equals(com.ivanov.accounting.realm.company.class)) {
                return clazz.cast(new io.realm.com_ivanov_accounting_realm_companyRealmProxy());
            }
            if (clazz.equals(com.ivanov.accounting.realm.employee.class)) {
                return clazz.cast(new io.realm.com_ivanov_accounting_realm_employeeRealmProxy());
            }
            if (clazz.equals(com.ivanov.accounting.realm.group.class)) {
                return clazz.cast(new io.realm.com_ivanov_accounting_realm_groupRealmProxy());
            }
            if (clazz.equals(com.ivanov.accounting.realm.product.class)) {
                return clazz.cast(new io.realm.com_ivanov_accounting_realm_productRealmProxy());
            }
            if (clazz.equals(com.ivanov.accounting.realm.reason.class)) {
                return clazz.cast(new io.realm.com_ivanov_accounting_realm_reasonRealmProxy());
            }
            if (clazz.equals(com.ivanov.accounting.realm.role.class)) {
                return clazz.cast(new io.realm.com_ivanov_accounting_realm_roleRealmProxy());
            }
            if (clazz.equals(com.ivanov.accounting.realm.status.class)) {
                return clazz.cast(new io.realm.com_ivanov_accounting_realm_statusRealmProxy());
            }
            if (clazz.equals(com.ivanov.accounting.realm.user.class)) {
                return clazz.cast(new io.realm.com_ivanov_accounting_realm_userRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.ivanov.accounting.realm.action.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_actionRealmProxy.copyOrUpdate(realm, (com.ivanov.accounting.realm.action) obj, update, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.actionType.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy.copyOrUpdate(realm, (com.ivanov.accounting.realm.actionType) obj, update, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.company.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_companyRealmProxy.copyOrUpdate(realm, (com.ivanov.accounting.realm.company) obj, update, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.employee.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_employeeRealmProxy.copyOrUpdate(realm, (com.ivanov.accounting.realm.employee) obj, update, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.group.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_groupRealmProxy.copyOrUpdate(realm, (com.ivanov.accounting.realm.group) obj, update, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.product.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_productRealmProxy.copyOrUpdate(realm, (com.ivanov.accounting.realm.product) obj, update, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.reason.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_reasonRealmProxy.copyOrUpdate(realm, (com.ivanov.accounting.realm.reason) obj, update, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.role.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_roleRealmProxy.copyOrUpdate(realm, (com.ivanov.accounting.realm.role) obj, update, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.status.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_statusRealmProxy.copyOrUpdate(realm, (com.ivanov.accounting.realm.status) obj, update, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.user.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_userRealmProxy.copyOrUpdate(realm, (com.ivanov.accounting.realm.user) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.ivanov.accounting.realm.action.class)) {
            io.realm.com_ivanov_accounting_realm_actionRealmProxy.insert(realm, (com.ivanov.accounting.realm.action) object, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.actionType.class)) {
            io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy.insert(realm, (com.ivanov.accounting.realm.actionType) object, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.company.class)) {
            io.realm.com_ivanov_accounting_realm_companyRealmProxy.insert(realm, (com.ivanov.accounting.realm.company) object, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.employee.class)) {
            io.realm.com_ivanov_accounting_realm_employeeRealmProxy.insert(realm, (com.ivanov.accounting.realm.employee) object, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.group.class)) {
            io.realm.com_ivanov_accounting_realm_groupRealmProxy.insert(realm, (com.ivanov.accounting.realm.group) object, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.product.class)) {
            io.realm.com_ivanov_accounting_realm_productRealmProxy.insert(realm, (com.ivanov.accounting.realm.product) object, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.reason.class)) {
            io.realm.com_ivanov_accounting_realm_reasonRealmProxy.insert(realm, (com.ivanov.accounting.realm.reason) object, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.role.class)) {
            io.realm.com_ivanov_accounting_realm_roleRealmProxy.insert(realm, (com.ivanov.accounting.realm.role) object, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.status.class)) {
            io.realm.com_ivanov_accounting_realm_statusRealmProxy.insert(realm, (com.ivanov.accounting.realm.status) object, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.user.class)) {
            io.realm.com_ivanov_accounting_realm_userRealmProxy.insert(realm, (com.ivanov.accounting.realm.user) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.ivanov.accounting.realm.action.class)) {
                io.realm.com_ivanov_accounting_realm_actionRealmProxy.insert(realm, (com.ivanov.accounting.realm.action) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.actionType.class)) {
                io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy.insert(realm, (com.ivanov.accounting.realm.actionType) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.company.class)) {
                io.realm.com_ivanov_accounting_realm_companyRealmProxy.insert(realm, (com.ivanov.accounting.realm.company) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.employee.class)) {
                io.realm.com_ivanov_accounting_realm_employeeRealmProxy.insert(realm, (com.ivanov.accounting.realm.employee) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.group.class)) {
                io.realm.com_ivanov_accounting_realm_groupRealmProxy.insert(realm, (com.ivanov.accounting.realm.group) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.product.class)) {
                io.realm.com_ivanov_accounting_realm_productRealmProxy.insert(realm, (com.ivanov.accounting.realm.product) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.reason.class)) {
                io.realm.com_ivanov_accounting_realm_reasonRealmProxy.insert(realm, (com.ivanov.accounting.realm.reason) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.role.class)) {
                io.realm.com_ivanov_accounting_realm_roleRealmProxy.insert(realm, (com.ivanov.accounting.realm.role) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.status.class)) {
                io.realm.com_ivanov_accounting_realm_statusRealmProxy.insert(realm, (com.ivanov.accounting.realm.status) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.user.class)) {
                io.realm.com_ivanov_accounting_realm_userRealmProxy.insert(realm, (com.ivanov.accounting.realm.user) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.ivanov.accounting.realm.action.class)) {
                    io.realm.com_ivanov_accounting_realm_actionRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.actionType.class)) {
                    io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.company.class)) {
                    io.realm.com_ivanov_accounting_realm_companyRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.employee.class)) {
                    io.realm.com_ivanov_accounting_realm_employeeRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.group.class)) {
                    io.realm.com_ivanov_accounting_realm_groupRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.product.class)) {
                    io.realm.com_ivanov_accounting_realm_productRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.reason.class)) {
                    io.realm.com_ivanov_accounting_realm_reasonRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.role.class)) {
                    io.realm.com_ivanov_accounting_realm_roleRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.status.class)) {
                    io.realm.com_ivanov_accounting_realm_statusRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.user.class)) {
                    io.realm.com_ivanov_accounting_realm_userRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.ivanov.accounting.realm.action.class)) {
            io.realm.com_ivanov_accounting_realm_actionRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.action) obj, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.actionType.class)) {
            io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.actionType) obj, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.company.class)) {
            io.realm.com_ivanov_accounting_realm_companyRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.company) obj, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.employee.class)) {
            io.realm.com_ivanov_accounting_realm_employeeRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.employee) obj, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.group.class)) {
            io.realm.com_ivanov_accounting_realm_groupRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.group) obj, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.product.class)) {
            io.realm.com_ivanov_accounting_realm_productRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.product) obj, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.reason.class)) {
            io.realm.com_ivanov_accounting_realm_reasonRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.reason) obj, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.role.class)) {
            io.realm.com_ivanov_accounting_realm_roleRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.role) obj, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.status.class)) {
            io.realm.com_ivanov_accounting_realm_statusRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.status) obj, cache);
        } else if (clazz.equals(com.ivanov.accounting.realm.user.class)) {
            io.realm.com_ivanov_accounting_realm_userRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.user) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.ivanov.accounting.realm.action.class)) {
                io.realm.com_ivanov_accounting_realm_actionRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.action) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.actionType.class)) {
                io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.actionType) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.company.class)) {
                io.realm.com_ivanov_accounting_realm_companyRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.company) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.employee.class)) {
                io.realm.com_ivanov_accounting_realm_employeeRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.employee) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.group.class)) {
                io.realm.com_ivanov_accounting_realm_groupRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.group) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.product.class)) {
                io.realm.com_ivanov_accounting_realm_productRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.product) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.reason.class)) {
                io.realm.com_ivanov_accounting_realm_reasonRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.reason) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.role.class)) {
                io.realm.com_ivanov_accounting_realm_roleRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.role) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.status.class)) {
                io.realm.com_ivanov_accounting_realm_statusRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.status) object, cache);
            } else if (clazz.equals(com.ivanov.accounting.realm.user.class)) {
                io.realm.com_ivanov_accounting_realm_userRealmProxy.insertOrUpdate(realm, (com.ivanov.accounting.realm.user) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.ivanov.accounting.realm.action.class)) {
                    io.realm.com_ivanov_accounting_realm_actionRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.actionType.class)) {
                    io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.company.class)) {
                    io.realm.com_ivanov_accounting_realm_companyRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.employee.class)) {
                    io.realm.com_ivanov_accounting_realm_employeeRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.group.class)) {
                    io.realm.com_ivanov_accounting_realm_groupRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.product.class)) {
                    io.realm.com_ivanov_accounting_realm_productRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.reason.class)) {
                    io.realm.com_ivanov_accounting_realm_reasonRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.role.class)) {
                    io.realm.com_ivanov_accounting_realm_roleRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.status.class)) {
                    io.realm.com_ivanov_accounting_realm_statusRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.ivanov.accounting.realm.user.class)) {
                    io.realm.com_ivanov_accounting_realm_userRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.ivanov.accounting.realm.action.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_actionRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.ivanov.accounting.realm.actionType.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.ivanov.accounting.realm.company.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_companyRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.ivanov.accounting.realm.employee.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_employeeRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.ivanov.accounting.realm.group.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_groupRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.ivanov.accounting.realm.product.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_productRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.ivanov.accounting.realm.reason.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_reasonRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.ivanov.accounting.realm.role.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_roleRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.ivanov.accounting.realm.status.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_statusRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.ivanov.accounting.realm.user.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_userRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.ivanov.accounting.realm.action.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_actionRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.ivanov.accounting.realm.actionType.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.ivanov.accounting.realm.company.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_companyRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.ivanov.accounting.realm.employee.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_employeeRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.ivanov.accounting.realm.group.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_groupRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.ivanov.accounting.realm.product.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_productRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.ivanov.accounting.realm.reason.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_reasonRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.ivanov.accounting.realm.role.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_roleRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.ivanov.accounting.realm.status.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_statusRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.ivanov.accounting.realm.user.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_userRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.ivanov.accounting.realm.action.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_actionRealmProxy.createDetachedCopy((com.ivanov.accounting.realm.action) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.actionType.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_actionTypeRealmProxy.createDetachedCopy((com.ivanov.accounting.realm.actionType) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.company.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_companyRealmProxy.createDetachedCopy((com.ivanov.accounting.realm.company) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.employee.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_employeeRealmProxy.createDetachedCopy((com.ivanov.accounting.realm.employee) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.group.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_groupRealmProxy.createDetachedCopy((com.ivanov.accounting.realm.group) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.product.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_productRealmProxy.createDetachedCopy((com.ivanov.accounting.realm.product) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.reason.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_reasonRealmProxy.createDetachedCopy((com.ivanov.accounting.realm.reason) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.role.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_roleRealmProxy.createDetachedCopy((com.ivanov.accounting.realm.role) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.status.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_statusRealmProxy.createDetachedCopy((com.ivanov.accounting.realm.status) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.ivanov.accounting.realm.user.class)) {
            return clazz.cast(io.realm.com_ivanov_accounting_realm_userRealmProxy.createDetachedCopy((com.ivanov.accounting.realm.user) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
