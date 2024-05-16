package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibsInPluginsBlock extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibsInPluginsBlock(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>com</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public ComLibraryAccessors getCom() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForComLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public OrgLibraryAccessors getOrg() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForOrgLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public BundleAccessors getBundles() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComH2databaseLibraryAccessors laccForComH2databaseLibraryAccessors = new ComH2databaseLibraryAccessors(owner);
        private final ComMysqlLibraryAccessors laccForComMysqlLibraryAccessors = new ComMysqlLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.h2database</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComH2databaseLibraryAccessors getH2database() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComH2databaseLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.mysql</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComMysqlLibraryAccessors getMysql() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComMysqlLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComH2databaseLibraryAccessors extends SubDependencyFactory {

        public ComH2databaseLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>h2</b> with <b>com.h2database:h2</b> coordinates and
         * with version reference <b>com.h2database.h2</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getH2() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("com.h2database.h2");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComMysqlLibraryAccessors extends SubDependencyFactory {
        private final ComMysqlMysqlLibraryAccessors laccForComMysqlMysqlLibraryAccessors = new ComMysqlMysqlLibraryAccessors(owner);

        public ComMysqlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.mysql.mysql</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComMysqlMysqlLibraryAccessors getMysql() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComMysqlMysqlLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComMysqlMysqlLibraryAccessors extends SubDependencyFactory {
        private final ComMysqlMysqlConnectorLibraryAccessors laccForComMysqlMysqlConnectorLibraryAccessors = new ComMysqlMysqlConnectorLibraryAccessors(owner);

        public ComMysqlMysqlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.mysql.mysql.connector</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComMysqlMysqlConnectorLibraryAccessors getConnector() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComMysqlMysqlConnectorLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComMysqlMysqlConnectorLibraryAccessors extends SubDependencyFactory {

        public ComMysqlMysqlConnectorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>j</b> with <b>com.mysql:mysql-connector-j</b> coordinates and
         * with version reference <b>com.mysql.mysql.connector.j</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJ() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("com.mysql.mysql.connector.j");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisLibraryAccessors laccForOrgMybatisLibraryAccessors = new OrgMybatisLibraryAccessors(owner);
        private final OrgSpringframeworkLibraryAccessors laccForOrgSpringframeworkLibraryAccessors = new OrgSpringframeworkLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mybatis</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgMybatisLibraryAccessors getMybatis() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgMybatisLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkLibraryAccessors getSpringframework() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgMybatisLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringLibraryAccessors laccForOrgMybatisSpringLibraryAccessors = new OrgMybatisSpringLibraryAccessors(owner);

        public OrgMybatisLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mybatis.spring</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgMybatisSpringLibraryAccessors getSpring() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgMybatisSpringLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgMybatisSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringBootLibraryAccessors laccForOrgMybatisSpringBootLibraryAccessors = new OrgMybatisSpringBootLibraryAccessors(owner);

        public OrgMybatisSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mybatis.spring.boot</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgMybatisSpringBootLibraryAccessors getBoot() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgMybatisSpringBootLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgMybatisSpringBootLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringBootMybatisLibraryAccessors laccForOrgMybatisSpringBootMybatisLibraryAccessors = new OrgMybatisSpringBootMybatisLibraryAccessors(owner);

        public OrgMybatisSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mybatis.spring.boot.mybatis</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgMybatisSpringBootMybatisLibraryAccessors getMybatis() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgMybatisSpringBootMybatisLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgMybatisSpringBootMybatisLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringBootMybatisSpringLibraryAccessors laccForOrgMybatisSpringBootMybatisSpringLibraryAccessors = new OrgMybatisSpringBootMybatisSpringLibraryAccessors(owner);

        public OrgMybatisSpringBootMybatisLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mybatis.spring.boot.mybatis.spring</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgMybatisSpringBootMybatisSpringLibraryAccessors getSpring() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgMybatisSpringBootMybatisSpringLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgMybatisSpringBootMybatisSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringBootMybatisSpringBootLibraryAccessors laccForOrgMybatisSpringBootMybatisSpringBootLibraryAccessors = new OrgMybatisSpringBootMybatisSpringBootLibraryAccessors(owner);

        public OrgMybatisSpringBootMybatisSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mybatis.spring.boot.mybatis.spring.boot</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgMybatisSpringBootMybatisSpringBootLibraryAccessors getBoot() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgMybatisSpringBootMybatisSpringBootLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgMybatisSpringBootMybatisSpringBootLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringBootMybatisSpringBootStarterLibraryAccessors laccForOrgMybatisSpringBootMybatisSpringBootStarterLibraryAccessors = new OrgMybatisSpringBootMybatisSpringBootStarterLibraryAccessors(owner);

        public OrgMybatisSpringBootMybatisSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mybatis.spring.boot.mybatis.spring.boot.starter</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgMybatisSpringBootMybatisSpringBootStarterLibraryAccessors getStarter() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgMybatisSpringBootMybatisSpringBootStarterLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgMybatisSpringBootMybatisSpringBootStarterLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public OrgMybatisSpringBootMybatisSpringBootStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>starter</b> with <b>org.mybatis.spring.boot:mybatis-spring-boot-starter</b> coordinates and
         * with version reference <b>org.mybatis.spring.boot.mybatis.spring.boot.starter</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.mybatis.spring.boot.mybatis.spring.boot.starter");
        }

        /**
         * Dependency provider for <b>test</b> with <b>org.mybatis.spring.boot:mybatis-spring-boot-starter-test</b> coordinates and
         * with version reference <b>org.mybatis.spring.boot.mybatis.spring.boot.starter.test</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getTest() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.mybatis.spring.boot.mybatis.spring.boot.starter.test");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootLibraryAccessors laccForOrgSpringframeworkBootLibraryAccessors = new OrgSpringframeworkBootLibraryAccessors(owner);

        public OrgSpringframeworkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkBootLibraryAccessors getBoot() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkBootLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringLibraryAccessors laccForOrgSpringframeworkBootSpringLibraryAccessors = new OrgSpringframeworkBootSpringLibraryAccessors(owner);

        public OrgSpringframeworkBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkBootSpringLibraryAccessors getSpring() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkBootSpringLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkBootSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootLibraryAccessors laccForOrgSpringframeworkBootSpringBootLibraryAccessors = new OrgSpringframeworkBootSpringBootLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkBootSpringBootLibraryAccessors getBoot() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkBootSpringBootLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkBootSpringBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>devtools</b> with <b>org.springframework.boot:spring-boot-devtools</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.devtools</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getDevtools() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.boot.spring.boot.devtools");
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors getStarter() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkBootSpringBootStarterLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jdbc</b> with <b>org.springframework.boot:spring-boot-starter-jdbc</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.jdbc</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJdbc() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.boot.spring.boot.starter.jdbc");
        }

        /**
         * Dependency provider for <b>test</b> with <b>org.springframework.boot:spring-boot-starter-test</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.test</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getTest() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.boot.spring.boot.starter.test");
        }

        /**
         * Dependency provider for <b>web</b> with <b>org.springframework.boot:spring-boot-starter-web</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.web</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getWeb() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.boot.spring.boot.starter.web");
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter.data</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors getData() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jpa</b> with <b>org.springframework.boot:spring-boot-starter-data-jpa</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.data.jpa</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJpa() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.boot.spring.boot.starter.data.jpa");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com</b>
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org</b>
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComH2databaseVersionAccessors vaccForComH2databaseVersionAccessors = new ComH2databaseVersionAccessors(providers, config);
        private final ComMysqlVersionAccessors vaccForComMysqlVersionAccessors = new ComMysqlVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.h2database</b>
         */
        public ComH2databaseVersionAccessors getH2database() {
            return vaccForComH2databaseVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.mysql</b>
         */
        public ComMysqlVersionAccessors getMysql() {
            return vaccForComMysqlVersionAccessors;
        }

    }

    public static class ComH2databaseVersionAccessors extends VersionFactory  {

        public ComH2databaseVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.h2database.h2</b> with value <b>2.2.224</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getH2() { return getVersion("com.h2database.h2"); }

    }

    public static class ComMysqlVersionAccessors extends VersionFactory  {

        private final ComMysqlMysqlVersionAccessors vaccForComMysqlMysqlVersionAccessors = new ComMysqlMysqlVersionAccessors(providers, config);
        public ComMysqlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.mysql.mysql</b>
         */
        public ComMysqlMysqlVersionAccessors getMysql() {
            return vaccForComMysqlMysqlVersionAccessors;
        }

    }

    public static class ComMysqlMysqlVersionAccessors extends VersionFactory  {

        private final ComMysqlMysqlConnectorVersionAccessors vaccForComMysqlMysqlConnectorVersionAccessors = new ComMysqlMysqlConnectorVersionAccessors(providers, config);
        public ComMysqlMysqlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.mysql.mysql.connector</b>
         */
        public ComMysqlMysqlConnectorVersionAccessors getConnector() {
            return vaccForComMysqlMysqlConnectorVersionAccessors;
        }

    }

    public static class ComMysqlMysqlConnectorVersionAccessors extends VersionFactory  {

        public ComMysqlMysqlConnectorVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.mysql.mysql.connector.j</b> with value <b>8.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJ() { return getVersion("com.mysql.mysql.connector.j"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgMybatisVersionAccessors vaccForOrgMybatisVersionAccessors = new OrgMybatisVersionAccessors(providers, config);
        private final OrgSpringframeworkVersionAccessors vaccForOrgSpringframeworkVersionAccessors = new OrgSpringframeworkVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mybatis</b>
         */
        public OrgMybatisVersionAccessors getMybatis() {
            return vaccForOrgMybatisVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springframework</b>
         */
        public OrgSpringframeworkVersionAccessors getSpringframework() {
            return vaccForOrgSpringframeworkVersionAccessors;
        }

    }

    public static class OrgMybatisVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringVersionAccessors vaccForOrgMybatisSpringVersionAccessors = new OrgMybatisSpringVersionAccessors(providers, config);
        public OrgMybatisVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mybatis.spring</b>
         */
        public OrgMybatisSpringVersionAccessors getSpring() {
            return vaccForOrgMybatisSpringVersionAccessors;
        }

    }

    public static class OrgMybatisSpringVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringBootVersionAccessors vaccForOrgMybatisSpringBootVersionAccessors = new OrgMybatisSpringBootVersionAccessors(providers, config);
        public OrgMybatisSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mybatis.spring.boot</b>
         */
        public OrgMybatisSpringBootVersionAccessors getBoot() {
            return vaccForOrgMybatisSpringBootVersionAccessors;
        }

    }

    public static class OrgMybatisSpringBootVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringBootMybatisVersionAccessors vaccForOrgMybatisSpringBootMybatisVersionAccessors = new OrgMybatisSpringBootMybatisVersionAccessors(providers, config);
        public OrgMybatisSpringBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mybatis.spring.boot.mybatis</b>
         */
        public OrgMybatisSpringBootMybatisVersionAccessors getMybatis() {
            return vaccForOrgMybatisSpringBootMybatisVersionAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringBootMybatisSpringVersionAccessors vaccForOrgMybatisSpringBootMybatisSpringVersionAccessors = new OrgMybatisSpringBootMybatisSpringVersionAccessors(providers, config);
        public OrgMybatisSpringBootMybatisVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mybatis.spring.boot.mybatis.spring</b>
         */
        public OrgMybatisSpringBootMybatisSpringVersionAccessors getSpring() {
            return vaccForOrgMybatisSpringBootMybatisSpringVersionAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisSpringVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringBootMybatisSpringBootVersionAccessors vaccForOrgMybatisSpringBootMybatisSpringBootVersionAccessors = new OrgMybatisSpringBootMybatisSpringBootVersionAccessors(providers, config);
        public OrgMybatisSpringBootMybatisSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mybatis.spring.boot.mybatis.spring.boot</b>
         */
        public OrgMybatisSpringBootMybatisSpringBootVersionAccessors getBoot() {
            return vaccForOrgMybatisSpringBootMybatisSpringBootVersionAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisSpringBootVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringBootMybatisSpringBootStarterVersionAccessors vaccForOrgMybatisSpringBootMybatisSpringBootStarterVersionAccessors = new OrgMybatisSpringBootMybatisSpringBootStarterVersionAccessors(providers, config);
        public OrgMybatisSpringBootMybatisSpringBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mybatis.spring.boot.mybatis.spring.boot.starter</b>
         */
        public OrgMybatisSpringBootMybatisSpringBootStarterVersionAccessors getStarter() {
            return vaccForOrgMybatisSpringBootMybatisSpringBootStarterVersionAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisSpringBootStarterVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public OrgMybatisSpringBootMybatisSpringBootStarterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.mybatis.spring.boot.mybatis.spring.boot.starter</b> with value <b>3.0.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("org.mybatis.spring.boot.mybatis.spring.boot.starter"); }

        /**
         * Version alias <b>org.mybatis.spring.boot.mybatis.spring.boot.starter.test</b> with value <b>3.0.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTest() { return getVersion("org.mybatis.spring.boot.mybatis.spring.boot.starter.test"); }

    }

    public static class OrgSpringframeworkVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootVersionAccessors vaccForOrgSpringframeworkBootVersionAccessors = new OrgSpringframeworkBootVersionAccessors(providers, config);
        public OrgSpringframeworkVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.boot</b>
         */
        public OrgSpringframeworkBootVersionAccessors getBoot() {
            return vaccForOrgSpringframeworkBootVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringVersionAccessors vaccForOrgSpringframeworkBootSpringVersionAccessors = new OrgSpringframeworkBootSpringVersionAccessors(providers, config);
        public OrgSpringframeworkBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring</b>
         */
        public OrgSpringframeworkBootSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkBootSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootVersionAccessors vaccForOrgSpringframeworkBootSpringBootVersionAccessors = new OrgSpringframeworkBootSpringBootVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring.boot</b>
         */
        public OrgSpringframeworkBootSpringBootVersionAccessors getBoot() {
            return vaccForOrgSpringframeworkBootSpringBootVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootStarterVersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterVersionAccessors = new OrgSpringframeworkBootSpringBootStarterVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.devtools</b> with value <b>3.2.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDevtools() { return getVersion("org.springframework.boot.spring.boot.devtools"); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring.boot.starter</b>
         */
        public OrgSpringframeworkBootSpringBootStarterVersionAccessors getStarter() {
            return vaccForOrgSpringframeworkBootSpringBootStarterVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootStarterDataVersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterDataVersionAccessors = new OrgSpringframeworkBootSpringBootStarterDataVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringBootStarterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.jdbc</b> with value <b>3.2.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJdbc() { return getVersion("org.springframework.boot.spring.boot.starter.jdbc"); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.test</b> with value <b>3.2.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTest() { return getVersion("org.springframework.boot.spring.boot.starter.test"); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.web</b> with value <b>3.2.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getWeb() { return getVersion("org.springframework.boot.spring.boot.starter.web"); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring.boot.starter.data</b>
         */
        public OrgSpringframeworkBootSpringBootStarterDataVersionAccessors getData() {
            return vaccForOrgSpringframeworkBootSpringBootStarterDataVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterDataVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkBootSpringBootStarterDataVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.data.jpa</b> with value <b>3.2.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJpa() { return getVersion("org.springframework.boot.spring.boot.starter.data.jpa"); }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
