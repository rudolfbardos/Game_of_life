package hu.isrv.game.of.life.config;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import java.util.Locale;

/**
 * Created by Rudi on 2017. 01. 19..
 */
public class UpperCaseNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return toUpperCase(name, context);
    }

    private Identifier toUpperCase(Identifier name, JdbcEnvironment context) {
        return context.getIdentifierHelper().toIdentifier(
                StringUtils.upperCase(name.getText(), Locale.ENGLISH));
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return toUpperCase(name, context);
    }



}
