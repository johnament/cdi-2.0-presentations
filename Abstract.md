New & Note Worthy:

High level abstract

Intro:

*New* and *Noteworthy* - Logical Disjunction
We'll be looking at interesting new features
As well as noteworthy existing features

Disclaimer?:
Funny disclaimer if I want

SE Session:
Stop by Thursday, 2:50 in Room 7

Current Status:

CDI 2.0 is in public final draft, expecting to complete at the end of April.  We're always looking for input, so stop by http://cdi-spec.org/ to take a look!

The New:

- Event Enhancements
- Java 8 Baseline
- Enhanced Configuration Capabilities in Extensions
- Applying interceptors to produced beans

The Noteworthy:

- Stereotypes
 -- Yes, CDI does DDD!
- 



Event Enhancements

Ordering

In the past, the order of observer methods was not guaranteed.  Starting with CDI 2.0 you can add a `@Priority` annotation to guarantee the order.

Examples...

BeanManager.getEvent()

We've increased the features going into an event.  As a result, the old BeanManager.fireEvent method stopped being too useful.  To avoid issues with sync, async and other features, we've introduced a getEvent method for programmatic instantiation.

Async Event support

CDI 2.0 introduces support for async events.  Async is a contract though for CDI - both the producer and consumer have to be async aware.

Async & Context Awareness

Under the hood, the context model of CDI is based on threads.  Whenever you have a new thread in place, its implicitly a new context.  This means that if you fire an async event, the original request context is not available.


Java 8 Alignment

CDI 2.0 is heavily aligned to Java 8.  Many new features are based on Java 8 semantics, functional interfaces used heavily to write simple code, instances can be streamed.

Instance Changes

You can now stream your instances.

Now includes a positive isResolvable method

Extension Configuration Improvements

For those using portable extensions, you can now easily configure the underlying objects.

Interceptors

There are certain cases where you want to create a bean based on some built in type.  In addition, you may want to add interceptors.

There's finally a solution for this.  InterceptionFactory will help wrap your third party libraries into CDI beans.

The Noteworthy

Stereotypes

- Under used feature.  Group your common qualifiers, scopes and interceptors together.
- You can add `@Component`
```
@Dependent
@Stereotype
@Target(TYPE)
@Retention(RUNTIME)
public @interface Component {}
```
Which just makes every component a dependent scoped bean.  Now you have a single reference to what your class structures look like
```
@ApplicationScoped
@Transactional
@Stereotype
@Target(TYPE)
@Retention(RUNTIME)
public @interface Service {}
```
You can even apply interceptors.

Alternatives

Alternatives allow you to have some amount of runtime replacement of beans.  In CDI 1.0 you needed an XML entry

CDI 1.1 introduced the `@Priority` annotation to allow it to be overridden purely by annotations

Decorators

More business logic, without changing the original

Portable Extensions

Use Cases
- Custom contexts
- Deployment time bean manipulation
- 3rd Party Component Bootstrapping

Controlled Bean Discovery

CDI 1.0 - use an empty beans.xml to activate CDI
CDI 1.1/1.2:
- All
All classes discovered, that match managed beans, are CDI beans
- Annotated
Classes discovered require a scope
- None
Classes in this archive are not discovered

It was found that annotated was too limiting, but all is too wide open, for performance reasons.  In order to compensate, and not break backwards compatibility, we introduced a <trim/> tag when using all discovery, that limits the found beans to those with bean defining annotations and those with scopes.

